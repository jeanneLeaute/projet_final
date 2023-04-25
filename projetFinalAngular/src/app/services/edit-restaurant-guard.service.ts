import { Restaurant } from './../model/restaurant';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { Injectable } from '@angular/core';
import {
  ActivatedRoute,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { Utilisateur } from '../model/utilisateur';
import { Role } from '../model/role';

@Injectable({
  providedIn: 'root',
})
export class EditRestaurantGuardService {
  restaurant!: Restaurant;
  constructor(
    private restaurantSrv: RestaurantService,
    private activatedRoute: ActivatedRoute
  ) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | boolean
    | UrlTree
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree> {
    if (sessionStorage.getItem('utilisateur')) {
      let utilisateur: Utilisateur = JSON.parse(
        sessionStorage.getItem('utilisateur')!
      ) as Utilisateur;
      this.activatedRoute.params.subscribe((params) => {
        if (params['id']) {
          this.restaurantSrv
            .getByIdWithRestaurateur(params['id'])
            .subscribe((data: Restaurant) => {
              this.restaurant = data;
            });
        }
      });
      console.debug(this.restaurant);
      return (
        utilisateur.role == Role.ROLE_RESTAURATEUR &&
        utilisateur.id == this.restaurant.restaurateur?.id
      );
    }
    return false;
  }
}
