import { Component } from '@angular/core';
import { Commentaire } from 'src/app/model/commentaire';
import { Utilisateur } from 'src/app/model/utilisateur';
import { CommentaireService } from 'src/app/services/commentaire.service';

@Component({
  selector: 'app-client-list-commentaire',
  templateUrl: './client-list-commentaire.component.html',
  styleUrls: ['./client-list-commentaire.component.css'],
})
export class ClientListCommentaireComponent {
  commentaires: Commentaire[] = [];

  constructor(private commentaireSrv: CommentaireService) {}
  ngOnInit(): void {
    this.initCommentaire();
  }

  initCommentaire() {
    this.commentaireSrv
      .getCommentaireByClient(this.IdUtilisateur)
      .subscribe((datas: Commentaire[]) => {
        this.commentaires = datas;
      });
  }

  delete(id: number) {
    this.commentaireSrv.deleteCommentaire(id).subscribe(() => {
      this.initCommentaire();
    });
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
