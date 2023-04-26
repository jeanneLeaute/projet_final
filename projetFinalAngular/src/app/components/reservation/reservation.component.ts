import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Restaurant } from 'src/app/model/restaurant';
import { RestaurantService } from 'src/app/services/restaurant.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css'],
})
export class ReservationComponent implements OnInit {
  restaurant!: Restaurant;
  constructor(
    private aR: ActivatedRoute,
    private restaurantSrv: RestaurantService,
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
  }
}
