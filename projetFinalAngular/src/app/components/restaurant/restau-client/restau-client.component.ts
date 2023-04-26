import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Restaurant } from 'src/app/model/restaurant';
import { RestaurantService } from 'src/app/services/restaurant.service';

@Component({
  selector: 'app-restau-client',
  templateUrl: './restau-client.component.html',
  styleUrls: ['./restau-client.component.css'],
})
export class RestauClientComponent {
  restaurantsRestaurateur!: Restaurant[];

  constructor(
    private restaurantSrv: RestaurantService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.initRestaurants();
  }

  initRestaurants() {
    this.restaurantSrv
      .allRestaurant()
      .subscribe((restaurants: Restaurant[]) => {
        this.restaurantsRestaurateur = restaurants;
      });
  }
}
