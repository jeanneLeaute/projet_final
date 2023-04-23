import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { InscriptionClientComponent } from './components/inscription/inscription-client/inscription-client.component';
import { InscriptionRestaurateurComponent } from './components/inscription/inscription-restaurateur/inscription-restaurateur.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'inscription-client', component: InscriptionClientComponent },
  { path: 'inscription-restaurateur', component: InscriptionRestaurateurComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
