import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Restaurateur } from '../model/restaurateur';
import { Observable } from 'rxjs';
import { ObjectToJsonService } from './object-to-json.service';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root',
})
export class RestaurateurService {
  constructor(
    private httpClient: HttpClient,
    private convert: ObjectToJsonService
  ) {}

  public allClient(): Observable<Utilisateur[]> {
    return this.httpClient.get<Utilisateur[]>(
      'http://localhost:8080/projetFinal/api/client'
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/eshop/api/client/${id}`
    );
  }

  public create(restaurateur: Utilisateur): Observable<Utilisateur> {
    console.debug(restaurateur);
    return this.httpClient.post<Utilisateur>(
      'http://localhost:8080/eshop/api/client/inscription',
      this.convert.utilisateurToJson(restaurateur)
    );
  }

  public update(restaurateur: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.put<Utilisateur>(
      `http://localhost:8080/eshop/api/client/${restaurateur.id}`,
      this.convert.utilisateurToJson(restaurateur)
    );
  }

  public getById(id: number): Observable<Restaurateur> {
    return this.httpClient.get<Restaurateur>(
      `http://localhost:8080/eshop/api/client/${id}`
    );
  }

  public getByLogin(login: string): Observable<Restaurateur> {
    return this.httpClient.get<Restaurateur>(
      `http://localhost:8080/eshop/api/client/${login}`
    );
  }
}
