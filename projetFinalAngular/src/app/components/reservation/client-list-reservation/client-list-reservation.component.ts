import { Component, OnInit } from '@angular/core';
import { CommandeADomicile } from 'src/app/model/commande-adomicile';
import { Role } from 'src/app/model/role';
import { SurPlace } from 'src/app/model/sur-place';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ClientService } from 'src/app/services/client.service';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-client-list-reservation',
  templateUrl: './client-list-reservation.component.html',
  styleUrls: ['./client-list-reservation.component.css'],
})
export class ClientListReservationComponent implements OnInit {
  reservationsSurPlace: Array<SurPlace> = new Array();
  reservationsCommande: Array<CommandeADomicile> = new Array();

  constructor(private reservationSrv: ReservationService) {}

  ngOnInit(): void {
    this.reservationSrv
      .getSurPlaceByClient(this.IdUtilisateur)
      .subscribe((data: any) => {
        this.reservationsSurPlace = data;
      });

    this.reservationSrv
      .getCommandeByClient(this.IdUtilisateur)
      .subscribe((data: any) => {
        this.reservationsCommande = data;
      });
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
}
