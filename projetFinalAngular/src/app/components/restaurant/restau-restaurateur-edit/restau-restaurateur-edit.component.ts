import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Restaurant } from 'src/app/model/restaurant';
import { Restaurateur } from 'src/app/model/restaurateur';
import { Role } from 'src/app/model/role';
import { Utilisateur } from 'src/app/model/utilisateur';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { RestaurateurService } from 'src/app/services/restaurateur.service';

@Component({
  selector: 'app-restau-restaurateur-edit',
  templateUrl: './restau-restaurateur-edit.component.html',
  styleUrls: ['./restau-restaurateur-edit.component.css'],
})
export class RestauRestaurateurEditComponent {
  restaurant!: Restaurant;
  restaurateur!: Utilisateur;

  constructor(
    private restaurantSrv: RestaurantService,
    private restaurateurSrv: RestaurateurService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.restaurant = new Restaurant();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.restaurantSrv
          .getById(params['id'])
          .subscribe((restaurant: Restaurant) => {
            this.restaurant = restaurant;
          });
      } else {
        this.restaurateur = new Utilisateur();
        if (this.isRestaurateur) {
          this.restaurateurSrv
            .getById(this.IdUtilisateur)
            .subscribe((data: Utilisateur) => {
              this.restaurant.restaurateur = data;
            });
        }
      }
    });
  }

  get isRestaurateur(): boolean {
    if (sessionStorage.getItem('utilisateur')) {
      let utilisateur: Utilisateur = JSON.parse(
        sessionStorage.getItem('utilisateur')!
      ) as Utilisateur;
      return utilisateur.role == Role.ROLE_RESTAURATEUR;
    }
    return false;
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

  save() {
    let obvResult: Observable<Restaurant>;
    if (this.restaurant.id) {
      obvResult = this.restaurantSrv.update(this.restaurant);
    } else {
      obvResult = this.restaurantSrv.create(this.restaurant);
    }
    obvResult.subscribe(() => {
      this.router.navigateByUrl('/restau-restaurateur');
    });
  }

  compareById(obj1: Restaurant, obj2: Restaurant) {
    return obj1 && obj2 && obj1.id == obj2.id;
  }
}
