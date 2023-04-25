import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
  restaurateur!: Utilisateur;
  restaurants: Restaurant[] = [];
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
  }

  initRestaurants() {
    if (this.restaurateur.id) {
      this.restaurantSrv
        .RestaurantsByRestaurateur(this.restaurateur.id)
        .subscribe((restaurants: Restaurant[]) => {
          this.restaurants = restaurants;
        });
    }
  }
}
