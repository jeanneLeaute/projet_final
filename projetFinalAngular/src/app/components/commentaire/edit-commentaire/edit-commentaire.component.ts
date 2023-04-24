import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Commentaire } from 'src/app/model/commentaire';
import { CommentaireService } from 'src/app/services/commentaire.service';

@Component({
  selector: 'app-edit-commentaire',
  templateUrl: './edit-commentaire.component.html',
  styleUrls: ['./edit-commentaire.component.css']
})
export class EditCommentaireComponent {

  constructor( private commentaireSrv: CommentaireService,private router: Router, private activatedRoute: ActivatedRoute){}

  commentaire!: Commentaire;
}
  ngOnInit(): void {
    this.commentaire = new Commentaire();
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.commentaireSrv.getCommentaireById(params['id']).subscribe((data: Commentaire)=> {
          this.commentaire=data;
        });
  }
}
  }
