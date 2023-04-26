import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Adresse } from 'src/app/model/adresse';
import { Categorie } from 'src/app/model/categorie';
import { CommandeADomicile } from 'src/app/model/commande-adomicile';
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
  adresse: Adresse = new Adresse('4', 'rue du restau', '34090', 'Montpellier');
  restau!: Restaurant;
  items!: Observable<ItemMenu[]>;
  client!: Utilisateur;

  constructor(
    private aR: ActivatedRoute,
    private restaurantSrv: RestaurantService,
    private commandeSrv: CommandeADomicileService,
    private router: Router,
    private itemMenuSrv: ItemMenuService,
    private clientSrv: ClientService
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

  public submit() {
    let surPlaceJson = {
      nom: this.form.get('nom')?.value,
      selectedItems: this.form.get('menuGroup.selectedItems')?.value,
    };
    this.commandeSrv.create(
      new CommandeADomicile(
        undefined,
        this.client,
        this.restau,
        undefined,
        undefined,
        undefined,
        this.form.get('menuGroup.selectedItems')?.value
      )
    );
    this.router.navigateByUrl('/home');
  }
}
