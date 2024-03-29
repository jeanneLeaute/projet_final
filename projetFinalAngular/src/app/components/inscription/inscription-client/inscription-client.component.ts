import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, map } from 'rxjs';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-inscription-client',
  templateUrl: './inscription-client.component.html',
  styleUrls: ['./inscription-client.component.css'],
})
export class InscriptionClientComponent implements OnInit {
  form!: FormGroup;

  constructor(private clientSrv: ClientService, private router: Router) {}

  ngOnInit(): void {
    this.form = new FormGroup({
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
    let clientJson = {
      nom: this.form.get('nom')?.value,
      prenom: this.form.get('prenom')?.value,
      login: this.form.get('compteGroup')?.get('login')?.value,
      password: this.form.get('compteGroup')?.get('passwordGrp')?.get('password')?.value,
      // adresse: {
      //   numero: this.form.get('numero')?.value,
      //   rue: this.form.get('rue')?.value,
      //   codePostal: this.form.get('codePostal')?.value,
      //   ville: this.form.get('ville')?.value,
      // },
    };
    this.clientSrv.inscription(clientJson).subscribe((client) => {
      console.debug(client);
      this.router.navigateByUrl('/login');
    });
  }
}

