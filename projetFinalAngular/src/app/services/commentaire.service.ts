import { Commentaire } from '../model/commentaire';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CommentaireService {
  constructor(private http: HttpClient) {}

  allCommentaires(): Observable<Commentaire[]> {
    return this.http.get<Commentaire[]>(
      'http://localhost:4200/api/commentaire'
    );
  }

  getCommentaireById(id: number): Observable<Commentaire> {
    const url = `http://localhost:4200/api/commentaire/${id}`;
    return this.http.get<Commentaire>(url);
  }

  createCommentaire(commentaire: Commentaire): Observable<Commentaire> {
    return this.http.post<Commentaire>(
      'http://localhost:4200/api/commentaire',
      commentaire
    );
  }

  updateCommentaire(commentaire: Commentaire): Observable<Commentaire> {
    const url = `http://localhost:4200/api/commentaire/${commentaire.id}`;
    return this.http.put<Commentaire>(url, commentaire);
  }

  deleteCommentaire(id: number): Observable<any> {
    const url = `http://localhost:4200/api/commentaire/${id}`;
    return this.http.delete(url);
  }
}
