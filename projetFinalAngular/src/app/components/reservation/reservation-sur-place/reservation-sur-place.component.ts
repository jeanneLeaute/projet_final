import { Restaurant } from './../../../model/restaurant';
import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, map, toArray } from 'rxjs';
import { Adresse } from 'src/app/model/adresse';
import { Categorie } from 'src/app/model/categorie';
import { Client } from 'src/app/model/client';
import { ItemMenu } from 'src/app/model/item-menu';
import { Role } from 'src/app/model/role';
import { SurPlace } from 'src/app/model/sur-place';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ClientService } from 'src/app/services/client.service';
import { ItemMenuService } from 'src/app/services/item-menu.service';
import { RestaurantService } from 'src/app/services/restaurant.service';
import { SurPlaceService } from 'src/app/services/sur-place.service';

@Component({
  selector: 'app-reservation-sur-place',
  templateUrl: './reservation-sur-place.component.html',
  styleUrls: ['./reservation-sur-place.component.css'],
})
export class ReservationSurPlaceComponent {
  adresse: Adresse = new Adresse('4', 'rue du restau', '34090', 'Montpellier');
  restau!: Restaurant;
  form!: FormGroup;
  items!: Observable<ItemMenu[]>;
  client!: Utilisateur;
  surPlace!: SurPlace;
  itemReserve: ItemMenu[] = new Array();

  constructor(
    private surPlaceSrv: SurPlaceService,
    private router: Router,
    private itemMenuSrv: ItemMenuService,
    private clientSrv: ClientService,
    private aR: ActivatedRoute,
    private restaurantSrv: RestaurantService
  ) {}

  ngOnInit(): void {
    this.restau = new Restaurant();
    this.aR.params.subscribe((params) => {
      if (params['id']) {
        this.restaurantSrv
          .getById(params['id'])
          .subscribe((restaurant: Restaurant) => {
            this.restau = restaurant;
          });
      }
    });
    this.client = new Utilisateur();
    if (this.isClient) {
      this.clientSrv
        .getById(this.IdUtilisateur)
        .subscribe((data: Utilisateur) => {
          this.client = data;
        });
    }
    this.form = new FormGroup({
      nom: new FormControl('', Validators.required),
      menuGroup: new FormGroup({
        selectedItems: new FormControl([]),
      }),
    });

    this.items = this.itemMenuSrv.findByRestaurant(this.restau);
  }

  get isClient(): boolean {
    if (sessionStorage.getItem('utilisateur')) {
      let utilisateur: Utilisateur = JSON.parse(
        sessionStorage.getItem('utilisateur')!
      ) as Utilisateur;
      return utilisateur.role == Role.ROLE_CLIENT;
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

  public itemReservationSurPlace(event: any) {
    this.itemReserve.push(event);
  }

  public submit() {
    let surPlaceJson = {
      nom: this.form.get('nom')?.value,
      selectedItems: this.form.get('menuGroup.selectedItems')?.value,
    };
    this.surPlace = new SurPlace(
      undefined,
      this.client,
      this.restau,
      undefined,
      undefined,
      undefined,
      this.form.get('menuGroup.selectedItems')?.value,
      undefined
    );
    this.surPlaceSrv.create(this.surPlace).subscribe(() => {
      this.router.navigateByUrl('/home');
    });
  }
}
