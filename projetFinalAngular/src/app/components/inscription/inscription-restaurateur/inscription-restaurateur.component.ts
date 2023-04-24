import { Component } from '@angular/core';
import { AbstractControl, AsyncValidatorFn, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, map } from 'rxjs';
import { RestaurateurService } from 'src/app/services/restaurateur.service';

@Component({
  selector: 'app-inscription-restaurateur',
  templateUrl: './inscription-restaurateur.component.html',
  styleUrls: ['./inscription-restaurateur.component.css']
})
export class InscriptionRestaurateurComponent {
  form!: FormGroup;

  constructor(private restaurateurSrv: RestaurateurService, private router: Router) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      prenom: new FormControl('', Validators.required),
      nom: new FormControl('', Validators.required),
      numero: new FormControl('', Validators.required),
      rue: new FormControl('', Validators.required),
      codePostal: new FormControl('', Validators.required),
      ville: new FormControl('', Validators.required),
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
    let restaurateurJson = {
      prenom: this.form.get('prenom')?.value,
      nom: this.form.get('nom')?.value,
      adresse: {
        numero: this.form.get('numero')?.value,
        rue: this.form.get('rue')?.value,
        codePostal: this.form.get('codePostal')?.value,
        ville: this.form.get('ville')?.value,
      },
      compte: {
        login: this.form.get('compteGroup.login')?.value,
        password: this.form.get('compteGroup.passwordGrp.password')?.value,
      },
    };
    this.restaurateurSrv.inscription(restaurateurJson).subscribe((restaurateur) => {
      console.debug(restaurateur);
      this.router.navigateByUrl('/login');
    });
  }
}
