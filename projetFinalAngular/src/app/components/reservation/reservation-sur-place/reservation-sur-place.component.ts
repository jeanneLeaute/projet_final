import { Restaurant } from './../../../model/restaurant';
import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Adresse } from 'src/app/model/adresse';
import { Categorie } from 'src/app/model/categorie';
import { ItemMenu } from 'src/app/model/item-menu';
import { ItemMenuService } from 'src/app/services/item-menu.service';
import { SurPlaceService } from 'src/app/services/sur-place.service';

@Component({
  selector: 'app-reservation-sur-place',
  templateUrl: './reservation-sur-place.component.html',
  styleUrls: ['./reservation-sur-place.component.css']
})
export class ReservationSurPlaceComponent {

  adresse:Adresse=new Adresse("4","rue du restau","34090","Montpellier");
  restau:Restaurant=new Restaurant(1,"restau","restau","19h-21h","aa",true,true,Categorie.pizzeria,this.adresse);
  form!: FormGroup;

  constructor(private itemMenuSrv:ItemMenuService,private surPlaceSrv: SurPlaceService, private router: Router) {}
  ngOnInit(): void {
    var itemMenu=this.itemMenuSrv.findByRestaurant(this.restau);
  }
  public submit(){}
}
