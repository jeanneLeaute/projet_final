import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Commentaire } from 'src/app/model/commentaire';
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

  commentaire!: Commentaire;
  client!: Utilisateur;
  restaurateur!: Utilisateur;

  ngOnInit(): void {
    this.commentaire = new Commentaire();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.commentaireSrv
          .getCommentaireById(params['id'])
          .subscribe((commentaire: Commentaire) => {
            this.commentaire = commentaire;
          });
      }
    });
  }

  save() {
    if (this.commentaire.id) {
      this.commentaireSrv.updateCommentaire(this.commentaire).subscribe(() => {
        this.router.navigateByUrl('/list-commentaire');
      });
    } else {
      this.commentaireSrv.createCommentaire(this.commentaire).subscribe(() => {
        this.router.navigateByUrl('/list-commentaire');
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
}
