import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { InscriptionClientComponent } from './components/inscription/inscription-client/inscription-client.component';
import { InscriptionRestaurateurComponent } from './components/inscription/inscription-restaurateur/inscription-restaurateur.component';
import { ListClientComponent } from './components/client/list-client/list-client.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { EditClientComponent } from './components/client/edit-client/edit-client.component';
import { DetailClientComponent } from './components/client/detail-client/detail-client.component';
import { EditRestaurateurComponent } from './components/restaurateur/edit-restaurateur/edit-restaurateur.component';
import { DetailRestaurateurComponent } from './components/restaurateur/detail-restaurateur/detail-restaurateur.component';
import { ListRestaurateurComponent } from './components/restaurateur/list-restaurateur/list-restaurateur.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'inscription-client', component: InscriptionClientComponent },
  {
    path: 'inscription-restaurateur',
    component: InscriptionRestaurateurComponent,
  },
  { path: 'list-client', component: ListClientComponent },
  { path: 'client/edit/:id', component: EditClientComponent },
  { path: 'client/detail/:id', component: DetailClientComponent },
  { path: 'list-restaurateur', component: ListRestaurateurComponent },
  { path: 'restaurateur/edit/:id', component: EditRestaurateurComponent },
  { path: 'restaurateur/detail/:id', component: DetailRestaurateurComponent },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
