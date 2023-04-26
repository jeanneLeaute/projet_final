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
      'http://localhost:8080/projetFinal/api/commentaire'
    );
  }

  getCommentaireByClient(idClient: number): Observable<Commentaire[]> {
    return this.http.get<Commentaire[]>(
      `http://localhost:8080/projetFinal/api/commentaire/client/${idClient}`
    );
  }

  getCommentaireByRestaurant(idRestaurant: number): Observable<Commentaire[]> {
    return this.http.get<Commentaire[]>(
      `http://localhost:8080/projetFinal/api/commentaire/restaurant/${idRestaurant}`
    );
  }

  getCommentaireByRestaurantAndClient(
    idRestaurant: number,
    idClient: number
  ): Observable<Commentaire[]> {
    return this.http.get<Commentaire[]>(
      `http://localhost:8080/projetFinal/api/commentaire/${idClient}/${idRestaurant}`
    );
  }

  getCommentaireById(id: number): Observable<Commentaire> {
    return this.http.get<Commentaire>(
      `http://localhost:8080/projetFinal/api/commentaire/${id}`
    );
  }

  getCommentaireByIdWithClient(id: number): Observable<Commentaire> {
    return this.http.get<Commentaire>(
      `http://localhost:8080/projetFinal/api/commentaire/${id}/client`
    );
  }

  getCommentaireByIdWithRestaurant(id: number): Observable<Commentaire> {
    return this.http.get<Commentaire>(
      `http://localhost:8080/projetFinal/api/commentaire/${id}/restaurant`
    );
  }

  createCommentaire(commentaire: Commentaire): Observable<Commentaire> {
    return this.http.post<Commentaire>(
      'http://localhost:8080/projetFinal/api/commentaire',
      commentaire
    );
  }

  updateCommentaire(commentaire: Commentaire): Observable<Commentaire> {
    return this.http.put<Commentaire>(
      `http://localhost:8080/projetFinal/api/commentaire/${commentaire.id}`,
      commentaire
    );
  }

  deleteCommentaire(id: number): Observable<any> {
    return this.http.delete(
      `http://localhost:8080/projetFinal/api/commentaire/${id}`
    );
  }
}
