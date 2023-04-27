import { Component, OnInit } from '@angular/core';
import { Restaurant } from 'src/app/model/restaurant';
import { RestaurantService } from 'src/app/services/restaurant.service';

@Component({
  selector: 'app-list-restaurant',
  templateUrl: './list-restaurant.component.html',
  styleUrls: ['./list-restaurant.component.css'],
})
export class ListRestaurantComponent implements OnInit {
  constructor(private restaurantSrv: RestaurantService) {}

  restaurants: Restaurant[] = [];
  ngOnInit(): void {
    this.initRestaurants();
  }

  initRestaurants() {
    this.restaurantSrv
      .allRestaurant()
      .subscribe((restaurants: Restaurant[]) => {
        this.restaurants = restaurants;
      });
  }

  delete(id: number) {
    this.restaurantSrv.delete(id).subscribe(() => {
      this.initRestaurants();
    });
  }
}
