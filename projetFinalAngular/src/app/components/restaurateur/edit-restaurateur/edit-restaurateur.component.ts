import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable, map } from 'rxjs';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ClientService } from 'src/app/services/client.service';
import { RestaurateurService } from 'src/app/services/restaurateur.service';

@Component({
  selector: 'app-edit-restaurateur',
  templateUrl: './edit-restaurateur.component.html',
  styleUrls: ['./edit-restaurateur.component.css'],
})
export class EditRestaurateurComponent implements OnInit {
  constructor(
    private restaurateurSrv: RestaurateurService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  form!: FormGroup;
  restaurateur!: Utilisateur;

  ngOnInit(): void {
    this.restaurateur = new Utilisateur();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.restaurateurSrv
          .getById(params['id'])
          .subscribe((data: Utilisateur) => {
            this.restaurateur = data;
          });
      }
    });

    this.form = new FormGroup({
      id: new FormControl(),
      prenom: new FormControl('', Validators.required),
      nom: new FormControl('', Validators.required),
      numero: new FormControl(''),
      rue: new FormControl(),
      codePostal: new FormControl(),
      ville: new FormControl(),
      compteGroup: new FormGroup(
        {
          login: new FormControl(
            '',
            Validators.required,
            this.loginFree(this.restaurateurSrv)
          ),
          passwordGrp: new FormGroup(
            {
              password: new FormControl(
                '',
                Validators.pattern(/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{3,}$/)
              ),
              confirm: new FormControl(''),
            },
            this.passwordAndConfirmEquals
          ),
        },
        this.loginAndPasswordNotEquals
      ),
    });
  }

  loginFree(srv: RestaurateurService): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      console.debug('check');
      return this.restaurateurSrv.checkLogin(control.value).pipe(
        map((exist: boolean) => {
          return exist ? { loginExist: true } : null;
        })
      );
    };
  }

  passwordAndConfirmEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('password')?.invalid) {
      return null;
    }
    return group.get('password')?.value == group.get('confirm')?.value
      ? null
      : { passwordAndConfirmNotEqual: true };
  }

  loginAndPasswordNotEquals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    if (group.get('login')?.invalid) {
      return null;
    }

    return group.get('login')?.value != group.get('passwordGrp.password')?.value
      ? null
      : { loginAndPasswordEquals: true };
  }

  submit() {
    this.restaurateur.nom = this.form.get('nom')?.value;
    this.restaurateur.prenom = this.form.get('prenom')?.value;
    this.restaurateur.login = this.form.get('compteGroup')?.get('login')?.value;
    this.restaurateur.password = this.form
      .get('compteGroup')
      ?.get('passwordGrp')
      ?.get('password')?.value;
    if (this.restaurateur.id) {
      this.restaurateurSrv.update(this.restaurateur).subscribe(() => {
        this.router.navigateByUrl('/list-restaurateur');
      });
    }
  }

  get IdUtilisateur(): number {
    if (sessionStorage.getItem('utilisateur')) {
      let utilisateur: Utilisateur = JSON.parse(
        sessionStorage.getItem('utilisateur')!
      ) as Utilisateur;
      return utilisateur.id!;
    }
    return 0;
  }
}
