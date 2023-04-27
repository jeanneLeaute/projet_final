import { Component } from '@angular/core';
import {
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Adresse } from 'src/app/model/adresse';
import { Categorie } from 'src/app/model/categorie';
import { CommandeADomicile } from 'src/app/model/commande-adomicile';
import { HeureReservation } from 'src/app/model/heure-reservation';
import { ItemMenu } from 'src/app/model/item-menu';
import { Restaurant } from 'src/app/model/restaurant';
import { Role } from 'src/app/model/role';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ClientService } from 'src/app/services/client.service';
import { CommandeADomicileService } from 'src/app/services/commande-adomicile.service';
import { ItemMenuService } from 'src/app/services/item-menu.service';
import { RestaurantService } from 'src/app/services/restaurant.service';

@Component({
  selector: 'app-reservation-commande-adomicile',
  templateUrl: './reservation-commande-adomicile.component.html',
  styleUrls: ['./reservation-commande-adomicile.component.css'],
})
export class ReservationCommandeADomicileComponent {
  form!: FormGroup;
  adresse!: Adresse;
  restau!: Restaurant;
  items!: Observable<ItemMenu[]>;
  client!: Utilisateur;
  commandeADomicile!: CommandeADomicile;
  itemReserve: Array<ItemMenu> = new Array<ItemMenu>();

  constructor(
    private aR: ActivatedRoute,
    private restaurantSrv: RestaurantService,
    private commandeSrv: CommandeADomicileService,
    private router: Router,
    private itemMenuSrv: ItemMenuService,
    private clientSrv: ClientService,
    private formBuilder: FormBuilder
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
      selectedItems: this.formBuilder.array([]),
      specification: new FormControl(''),
      numero: new FormControl(''),
      rue: new FormControl(),
      codePostal: new FormControl(),
      ville: new FormControl(),
    });
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

  public itemReservationCommandeADomicile(e: any) {
    const selectedItems: FormArray = this.form.get(
      'selectedItems'
    ) as FormArray;

    if (e.target.checked) {
      selectedItems.push(new FormControl(e.target.value));
      this.itemMenuSrv.getById(e.target.value).subscribe((data: ItemMenu) => {
        this.itemReserve.push(data);
      });
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
    this.adresse = new Adresse();
    this.adresse.numero = this.form.get('numero')?.value;
    this.adresse.rue = this.form.get('rue')?.value;
    this.adresse.codePostal = this.form.get('codePostal')?.value;
    this.adresse.ville = this.form.get('ville')?.value;
    this.commandeADomicile = new CommandeADomicile(
      this.adresse,
      this.client,
      undefined,
      this.restau,
      undefined,
      this.form.value.specification,
      this.itemReserve
    );

    let commandeAdomicileJson = {
      adresse: {
        numero: this.adresse.numero,
        rue: this.adresse.rue,
        codePostal: this.adresse.codePostal,
        ville: this.adresse.codePostal,
      },
      client: this.commandeADomicile.client,
      restaurant: this.commandeADomicile.restaurant,
      date: this.commandeADomicile.date,
      specification: this.commandeADomicile.specification,
      itemsMenu: this.itemReserve,
    };

    this.commandeSrv.create(commandeAdomicileJson).subscribe((resp) => {
      this.router.navigateByUrl('/restau-client');
    });
  }
}
