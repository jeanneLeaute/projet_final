import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { SurPlaceService } from 'src/app/services/sur-place.service';

@Component({
  selector: 'app-reservation-sur-place',
  templateUrl: './reservation-sur-place.component.html',
  styleUrls: ['./reservation-sur-place.component.css']
})
export class ReservationSurPlaceComponent {
  form!: FormGroup;

  constructor(private surPlaceSrv: SurPlaceService, private router: Router) {}
}
