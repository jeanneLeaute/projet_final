import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CommandeADomicile } from 'src/app/model/commande-adomicile';
import { Reservation } from 'src/app/model/reservation';
import { Restaurant } from 'src/app/model/restaurant';
import { Role } from 'src/app/model/role';
import { SurPlace } from 'src/app/model/sur-place';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ReservationService } from 'src/app/services/reservation.service';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { RestaurateurService } from 'src/app/services/restaurateur.service';

@Component({
  selector: 'app-restau-reservation',
  templateUrl: './restau-reservation.component.html',
  styleUrls: ['./restau-reservation.component.css']
})
export class RestauReservationComponent {

  restaurant!: Restaurant;
  idRestaurateur!: number;
  reservationsSurPlace:Array<SurPlace>=new Array;
  reservationsCommande:Array<CommandeADomicile>=new Array;

  constructor(
    private reservationSrv:ReservationService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      this.idRestaurateur=params['id']

      this.reservationSrv.getSurPlaceByRestaurant(this.idRestaurateur).subscribe((data:any)=>{
        this.reservationsSurPlace=data;
      })

      this.reservationSrv.getCommandeByRestaurant(this.idRestaurateur).subscribe((data:any)=>{
        this.reservationsCommande=data;
        console.log(this.reservationsCommande)
      })

    })
  }

  public traite(id:number|undefined){}

}
