import { SurPlace } from './../../../model/sur-place';
import { HeureReservation } from './../../../model/heure-reservation';
import { Restaurant } from './../../../model/restaurant';
import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, map, toArray } from 'rxjs';
import { Adresse } from 'src/app/model/adresse';
import { ItemMenu } from 'src/app/model/item-menu';
import { Role } from 'src/app/model/role';
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
  itemReserve: Array<ItemMenu> = new Array<ItemMenu>();
  localdate!: string;
  heuresReservation=Object.values(HeureReservation)

  constructor(
    private surPlaceSrv: SurPlaceService,
    private router: Router,
    private itemMenuSrv: ItemMenuService,
    private clientSrv: ClientService,
    private aR: ActivatedRoute,
    private restaurantSrv: RestaurantService,
    private formBuilder : FormBuilder,
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
      nbPersonne: new FormControl('', Validators.required),
      heureReservation:new FormControl(''),
      selectedItems: this.formBuilder.array([]),
      specification:new FormControl(''),
    })

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
      this.itemMenuSrv.getById(e.target.value).subscribe((data:ItemMenu)=>{
        this.itemReserve.push(data);
      })
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

    // for(let i=0;i<this.form.value.selectedItems.length;i++){
    //   this.itemMenuSrv.getById(this.form.value.selectedItems[i]).subscribe((data:ItemMenu)=>{
    //     this.itemReserve.push(data);
    //   })
    // }

    this.surPlace = new SurPlace(
      undefined,
      this.client,
      this.restau,
      undefined,
      this.form.value.specification,
      this.form.value.nbPersonne,
      undefined,
      this.itemReserve,
      this.form.value.heureReservation
    );

    let surPlaceJson = {
      client: this.surPlace.client,
      restaurant: this.surPlace.restaurant,
      date: this.surPlace.date,
      specification: this.surPlace.specification,
      nbPersonne:this.surPlace.nbPersonne,
      choixTables: this.surPlace.choixTables,
      itemsMenu: this.itemReserve,
      heureReservation: this.surPlace.heureReservation,
    };


    this.surPlaceSrv.create(surPlaceJson).subscribe((resp)=>{
      // console.debug(this.surPlace);
      this.router.navigateByUrl("/restau-client")
    });

  }
}
