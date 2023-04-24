import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { LinkComponent } from './components/link/link.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { AuthInterceptor } from './interceptor/auth-interceptor';
import { InscriptionClientComponent } from './components/inscription/inscription-client/inscription-client.component';
import { InscriptionRestaurateurComponent } from './components/inscription/inscription-restaurateur/inscription-restaurateur.component';
import { ListClientComponent } from './components/client/list-client/list-client.component';
import { EditClientComponent } from './components/client/edit-client/edit-client.component';
import { ListRestaurateurComponent } from './components/restaurateur/list-restaurateur/list-restaurateur.component';
import { EditRestaurateurComponent } from './components/restaurateur/edit-restaurateur/edit-restaurateur.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { DetailClientComponent } from './components/client/detail-client/detail-client.component';
import { DetailRestaurateurComponent } from './components/restaurateur/detail-restaurateur/detail-restaurateur.component';
import { RestaurateurService } from './services/restaurateur.service';
import { EditRestaurantComponent } from './components/restaurant/edit-restaurant/edit-restaurant.component';
import { ListRestaurantComponent } from './components/restaurant/list-restaurant/list-restaurant.component';
import { DetailAdminComponent } from './components/admin/detail-admin/detail-admin.component';
import { ReservationSurPlaceComponent } from './components/reservation/reservation-sur-place/reservation-sur-place.component';
import { ReservationCommandeADomicileComponent } from './components/reservation/reservation-commande-adomicile/reservation-commande-adomicile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent,
    LinkComponent,
    InscriptionComponent,
    LoginComponent,
    InscriptionClientComponent,
    InscriptionRestaurateurComponent,
    ListClientComponent,
    EditClientComponent,
    ListRestaurateurComponent,
    ListRestaurantComponent,
    EditRestaurateurComponent,
    EditRestaurantComponent,
    NotFoundComponent,
    DetailClientComponent,
    DetailRestaurateurComponent,
    DetailAdminComponent,
    ReservationSurPlaceComponent,
    ReservationCommandeADomicileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],

  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
