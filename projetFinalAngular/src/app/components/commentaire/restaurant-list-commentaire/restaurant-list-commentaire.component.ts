import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Commentaire } from 'src/app/model/commentaire';
import { CommentaireService } from 'src/app/services/commentaire.service';

@Component({
  selector: 'app-restaurant-list-commentaire',
  templateUrl: './restaurant-list-commentaire.component.html',
  styleUrls: ['./restaurant-list-commentaire.component.css'],
})
export class RestaurantListCommentaireComponent {
  commentaires: Commentaire[] = [];

  constructor(
    private commentaireSrv: CommentaireService,
    private activatedRoute: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.initCommentaires();
  }

  initCommentaires() {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.commentaireSrv
          .getCommentaireByRestaurant(params['id'])
          .subscribe((datas: Commentaire[]) => {
            this.commentaires = datas;
          });
      }
    });
  }
}
