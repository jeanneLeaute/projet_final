import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Restaurant } from 'src/app/model/restaurant';
import { Restaurateur } from 'src/app/model/restaurateur';
import { Utilisateur } from 'src/app/model/utilisateur';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { RestaurateurService } from 'src/app/services/restaurateur.service';

@Component({
  selector: 'app-restau-restaurateur',
  templateUrl: './restau-restaurateur.component.html',
  styleUrls: ['./restau-restaurateur.component.css'],
})
export class RestauRestaurateurComponent implements OnInit {
  restaurant!: Restaurant;
  restaurantsRestaurateur!: Restaurant[];
  restaurateur!: Utilisateur;
  constructor(
    private restaurateurSrv: RestaurateurService,
    private restaurantSrv: RestaurantService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.restaurateur = new Utilisateur();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.restaurateurSrv
          .getById(params['id'])
          .subscribe((datas: Utilisateur) => {
            this.restaurateur = datas;
          });
      }
    });
    this.initRestaurants();
    this.restaurant.restaurateur = this.restaurateur;
  }

  initRestaurants() {
    if (this.IdUtilisateur) {
      this.restaurantSrv
        .RestaurantsByRestaurateur(this.IdUtilisateur)
        .subscribe((restaurants: Restaurant[]) => {
          this.restaurantsRestaurateur = restaurants;
        });
    }
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

  delete(id: number) {
    this.restaurantSrv.delete(id).subscribe(() => {
      this.initRestaurants();
    });
  }
}
