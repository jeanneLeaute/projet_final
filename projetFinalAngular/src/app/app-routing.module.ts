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
import { MoncompteClientComponent } from './components/client/moncompte-client/moncompte-client.component';
import { MoncompteRestaurateurComponent } from './components/restaurateur/moncompte-restaurateur/moncompte-restaurateur.component';
import { EditMoncompteRestaurateurComponent } from './components/restaurateur/edit-moncompte-restaurateur/edit-moncompte-restaurateur.component';
import { EditMoncompteClientComponent } from './components/client/edit-moncompte-client/edit-moncompte-client.component';
import { EditRestaurantGuardService } from './services/edit-restaurant-guard.service';
import { RestauClientComponent } from './components/restaurant/restau-client/restau-client.component';
import { RestaurantListCommentaireComponent } from './components/commentaire/restaurant-list-commentaire/restaurant-list-commentaire.component';
import { RestauReservationComponent } from './components/restaurant/restau-reservation/restau-reservation.component';
import { CommandeValideComponent } from './components/reservation/commande-valide/commande-valide.component';

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
    path: 'reservation-surplace/:id',
    component: ReservationSurPlaceComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'reservation-commande-adomicile/:id',
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
    canActivate: [EditRestaurantGuardService],
  },
  {
    path: 'restau-reservation/:id',
    component: RestauReservationComponent,
    // canActivate: [EditRestaurantGuardService],
  },
  {
    path: 'restau-client',
    component: RestauClientComponent,
  },
  {
    path: 'list-client',
    component: ListClientComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'client/edit/:id',
    component: EditClientComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'client/edit-moncompte',
    component: EditMoncompteClientComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'client/detail/:id',
    component: DetailClientComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'client/moncompte',
    component: MoncompteClientComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'reservation/:id',
    component: ReservationComponent,
  },
  {
    path: 'list-restaurateur',
    component: ListRestaurateurComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'restaurateur/edit/:id',
    component: EditRestaurateurComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'restaurateur/edit-moncompte',
    component: EditMoncompteRestaurateurComponent,
    canActivate: [RestaurateurGuardService],
  },
  {
    path: 'restaurateur/detail/:id',
    component: DetailRestaurateurComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'restaurateur/moncompte',
    component: MoncompteRestaurateurComponent,
    canActivate: [RestaurateurGuardService],
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
    path: 'list-commentaire/restaurant/:id',
    component: RestaurantListCommentaireComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'commentaire/edit/:id',
    component: EditCommentaireComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'commentaire/add/:idRestaurant',
    component: EditCommentaireComponent,
    canActivate: [ClientGuardService],
  },
  { path: 'reservation/validee', component: CommandeValideComponent },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
