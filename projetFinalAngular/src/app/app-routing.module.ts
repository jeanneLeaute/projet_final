import { AdminGuardService } from './services/admin-guard.service';
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
import { AnonymousGuardService } from './services/anonymous-guard.service';
import { AuthGuardService } from './services/auth-guard.service';
import { RestaurateurGuardService } from './services/restaurateur-guard.service';
import { ClientGuardService } from './services/client-guard.service';
import { DetailAdminComponent } from './components/admin/detail-admin/detail-admin.component';
import { ReservationComponent } from './components/reservation/reservation.component';
import { ReservationSurPlaceComponent } from './components/reservation/reservation-sur-place/reservation-sur-place.component';
import { ReservationCommandeADomicileComponent } from './components/reservation/reservation-commande-adomicile/reservation-commande-adomicile.component';
import { RestauRestaurateurComponent } from './components/restaurant/restau-restaurateur/restau-restaurateur.component';
import { RestauRestaurateurEditComponent } from './components/restaurant/restau-restaurateur-edit/restau-restaurateur-edit.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'reservation',
    component: ReservationComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'reservation-surplace',
    component: ReservationSurPlaceComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'reservation-commande-adomicile',
    component: ReservationCommandeADomicileComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'inscription',
    component: InscriptionComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'inscription-client',
    component: InscriptionClientComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'inscription-restaurateur',
    component: InscriptionRestaurateurComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'restaurant',
    component: ListRestaurantComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'restaurant/add',
    component: EditRestaurantComponent,
    canActivate: [RestaurateurGuardService],
  },
  {
    path: 'restaurant/edit/:id',
    component: EditRestaurantComponent,
    canActivate: [RestaurateurGuardService],
  },
  {
    path: 'restau-restaurateur',
    component: RestauRestaurateurComponent,
  },
  {
    path: 'restau-restaurateur/add',
    component: RestauRestaurateurEditComponent,
  },
  {
    path: 'restau-restaurateur/edit/:id',
    component: RestauRestaurateurEditComponent,
  },
  {
    path: 'list-client',
    component: ListClientComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'client/edit/:id',
    component: EditClientComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'client/detail/:id',
    component: DetailClientComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'client/detail/moncompte',
    component: DetailClientComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'list-restaurateur',
    component: ListRestaurateurComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'restaurateur/edit/:id',
    component: EditRestaurateurComponent,
    canActivate: [RestaurateurGuardService],
  },
  {
    path: 'restaurateur/detail/:id',
    component: DetailRestaurateurComponent,
    canActivate: [RestaurateurGuardService],
  },
  {
    path: 'restaurateur/detail/moncompte',
    component: DetailRestaurateurComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'admin/detail/:id',
    component: DetailAdminComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'list-commentaire',
    component: ListCommentaireComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'commentaire/edit/:id',
    component: EditCommentaireComponent,
    canActivate: [ClientGuardService],
  },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
