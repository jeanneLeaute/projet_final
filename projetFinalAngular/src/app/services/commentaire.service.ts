import { Commentaire } from '../model/commentaire';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CommentaireService {
  private baseUrl = 'http://localhost:4200/api/commentaires';

  constructor(private http: HttpClient) {}

  getCommentaires(): Observable<Commentaire[]> {
    return this.http.get<Commentaire[]>(this.baseUrl);
  }

  getCommentaireById(id: string): Observable<Commentaire> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Commentaire>(url);
  }

  addCommentaire(commentaire: Commentaire): Observable<Commentaire> {
    return this.http.post<Commentaire>(this.baseUrl, commentaire);
  }

  updateCommentaire(commentaire: Commentaire): Observable<Commentaire> {
    const url = `${this.baseUrl}/${commentaire.id}`;
    return this.http.put<Commentaire>(url, commentaire);
  }

  deleteCommentaire(id: string): Observable<any> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete(url);
  }
}
