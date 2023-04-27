import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Commentaire } from 'src/app/model/commentaire';
import { Restaurant } from 'src/app/model/restaurant';
import { Role } from 'src/app/model/role';
import { Utilisateur } from 'src/app/model/utilisateur';
import { ClientService } from 'src/app/services/client.service';
import { CommentaireService } from 'src/app/services/commentaire.service';
import { RestaurantService } from 'src/app/services/restaurant.service';

@Component({
  selector: 'app-edit-commentaire',
  templateUrl: './edit-commentaire.component.html',
  styleUrls: ['./edit-commentaire.component.css'],
})
export class EditCommentaireComponent {
  utilisateur: any;
  commentaires: any;

  constructor(
    private commentaireSrv: CommentaireService,
    private clientSrv: ClientService,
    private restaurantSrv: RestaurantService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  form!: FormGroup;
  commentaire!: Commentaire;
  client!: Utilisateur;
  restaurant!: Restaurant;

  ngOnInit(): void {
    this.commentaire = new Commentaire();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.commentaireSrv
          .getCommentaireById(params['id'])
          .subscribe((datas: Commentaire) => {
            this.commentaire = datas;
          });
      }
    });
    this.client = new Utilisateur();
    if (this.isClient) {
      this.clientSrv
        .getById(this.IdUtilisateur)
        .subscribe((datas: Utilisateur) => {
          this.client = datas;
        });
    }
    this.restaurant = new Restaurant();
    this.activatedRoute.params.subscribe((params) => {
      if (params['idRestaurant']) {
        this.restaurantSrv
          .getById(params['idRestaurant'])
          .subscribe((datas: Restaurant) => {
            this.restaurant = datas;
          });
      }
    });
    this.form = new FormGroup({
      texte: new FormControl(),
    });
  }

  submit() {
    console.debug(this.commentaire);
    console.debug(this.client);
    console.debug(this.restaurant);
    console.debug(this.form.get('texte')?.value);
    if (this.commentaire.id) {
      this.commentaire.texte = this.form.get('texte')?.value;
      this.commentaireSrv.updateCommentaire(this.commentaire).subscribe(() => {
        console.debug(this.commentaire);
        this.router.navigateByUrl('/client/moncompte');
      });
    } else {
      this.commentaire.client = this.client;
      this.commentaire.restaurant = this.restaurant;
      this.commentaire.texte = this.form.get('texte')?.value;
      this.commentaireSrv.createCommentaire(this.commentaire).subscribe(() => {
        console.debug(this.commentaire);
        this.router.navigateByUrl('/restau-client');
      });
    }
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

  get isClient(): boolean {
    if (sessionStorage.getItem('utilisateur')) {
      let utilisateur: Utilisateur = JSON.parse(
        sessionStorage.getItem('utilisateur')!
      ) as Utilisateur;
      return utilisateur.role == Role.ROLE_CLIENT;
    }
    return false;
  }
}
