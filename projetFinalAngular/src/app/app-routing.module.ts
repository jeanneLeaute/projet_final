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
import { ListRestaurantComponent } from './components/restaurant/list-restaurant/list-restaurant.component';
import { EditRestaurantComponent } from './components/restaurant/edit-restaurant/edit-restaurant.component';
import { ListCommentaireComponent } from './components/commentaire/list-commentaire/list-commentaire.component';
import { EditCommentaireComponent } from './components/commentaire/edit-commentaire/edit-commentaire.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'inscription-client', component: InscriptionClientComponent },
  {
    path: 'inscription-restaurateur',
    component: InscriptionRestaurateurComponent,
  },
  { path: 'restaurant', component: ListRestaurantComponent },
  {
    path: 'restaurant/add',
    component: EditRestaurantComponent,
  },
  {
    path: 'restaurant/edit/:id',
    component: EditRestaurantComponent,
  },
  { path: 'list-client', component: ListClientComponent },
  { path: 'client/edit/:id', component: EditClientComponent },
  { path: 'client/detail/:id', component: DetailClientComponent },
  { path: 'list-restaurateur', component: ListRestaurateurComponent },
  { path: 'restaurateur/edit/:id', component: EditRestaurateurComponent },
  { path: 'restaurateur/detail/:id', component: DetailRestaurateurComponent },
  { path: 'list-commentaire', component: ListCommentaireComponent },
  { path: 'commentaire/edit/:id', component: EditCommentaireComponent },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
