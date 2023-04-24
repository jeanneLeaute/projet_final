import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Restaurant } from 'src/app/model/restaurant';
import { Restaurateur } from 'src/app/model/restaurateur';
import { Utilisateur } from 'src/app/model/utilisateur';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { RestaurateurService } from 'src/app/services/restaurateur.service';

@Component({
  selector: 'app-edit-restaurant',
  templateUrl: './edit-restaurant.component.html',
  styleUrls: ['./edit-restaurant.component.css'],
})
export class EditRestaurantComponent {
  restaurant!: Restaurant;
  obsRestaurateurs!: Observable<Utilisateur[]>;

  constructor(
    private aR: ActivatedRoute,
    private restaurantSrv: RestaurantService,
    private restaurateurSrv: RestaurateurService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.restaurant = new Restaurant();
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.restaurantSrv
          .getById(params['id'])
          .subscribe((restaurant: Restaurant) => {
            this.restaurant = restaurant;
          });
      }
    });
    this.obsRestaurateurs = this.restaurateurSrv.allRestaurateur();
  }

  save() {
    let obvResult: Observable<Restaurant>;
    if (this.restaurant.id) {
      obvResult = this.restaurantSrv.update(this.restaurant);
    } else {
      obvResult = this.restaurantSrv.create(this.restaurant);
    }
    obvResult.subscribe(() => {
      this.router.navigateByUrl('/produit');
    });
  }

  compareById(obj1: Restaurant, obj2: Restaurant) {
    return obj1 && obj2 && obj1.id == obj2.id;
  }
}
