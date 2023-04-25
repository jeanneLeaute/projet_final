import { Component } from '@angular/core';
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
import { Role } from 'src/app/model/role';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-edit-moncompte-client',
  templateUrl: './edit-moncompte-client.component.html',
  styleUrls: ['./edit-moncompte-client.component.css'],
})
export class EditMoncompteClientComponent {
  constructor(private clientSrv: ClientService, private router: Router) {}

  form!: FormGroup;
  client!: Utilisateur;

  ngOnInit(): void {
    this.client = new Utilisateur();
    if (this.isClient) {
      this.clientSrv
        .getById(this.IdUtilisateur)
        .subscribe((datas: Utilisateur) => {
          this.client = datas;
        });
    }
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
            this.loginFree(this.clientSrv)
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

  loginFree(srv: ClientService): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      console.debug('check');
      return this.clientSrv.checkLogin(control.value).pipe(
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
    this.client.nom = this.form.get('nom')?.value;
    this.client.prenom = this.form.get('prenom')?.value;
    this.client.login = this.form.get('compteGroup')?.get('login')?.value;
    this.client.password = this.form
      .get('compteGroup')
      ?.get('passwordGrp')
      ?.get('password')?.value;
    if (this.client.id) {
      this.clientSrv.update(this.client).subscribe(() => {
        sessionStorage.clear();
        this.router.navigateByUrl('/login');
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

  get isClient(): boolean {
    if (sessionStorage.getItem('utilisateur')) {
      let utilisateur: Utilisateur = JSON.parse(
        sessionStorage.getItem('utilisateur')!
      ) as Utilisateur;
      return utilisateur.role == Role.ROLE_CLIENT;
    }
    return false;
  }
}
