import { Component } from '@angular/core';
import { Commentaire } from 'src/app/model/commentaire';
import { CommentaireService } from 'src/app/services/commentaire.service';

@Component({
  selector: 'app-list-commentaire',
  templateUrl: './list-commentaire.component.html',
  styleUrls: ['./list-commentaire.component.css'],
})
export class ListCommentaireComponent {
  commentaires: Commentaire[] = [];

  constructor(private commentaireSrv: CommentaireService) {}
  ngOnInit(): void {
    this.initCommentaire();
  }

  initCommentaire() {
    this.commentaireSrv.allCommentaires().subscribe((datas: Commentaire[]) => {
      this.commentaires = datas;
    });
  }
}
