import { Restaurant } from './../../../model/restaurant';
import { Component } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
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
            this.items = this.itemMenuSrv.findByRestaurant(this.restau);
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
        selectedItems: new FormControl([false]),
      }),
    });
    console.debug(this.restau);

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

  public itemReservationSurPlace(e: any) {
    const selectedItems: FormArray = this.form.get('selectedItems') as FormArray;
    if (e.target.checked) {
      selectedItems.push(new FormControl(e.target.value));
    } else {
      let i: number = 0;
      selectedItems.controls.forEach((t: any) => {
        if (t.value == e.target.value) {
          selectedItems.removeAt(i);
          return;
        }
        i++;
      });
    }
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

    console.log(this.surPlace);
    this.surPlaceSrv.create(this.surPlace).subscribe(() => {
      this.router.navigateByUrl('/home');
    });
  }
}
