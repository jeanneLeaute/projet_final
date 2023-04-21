import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Restaurateur } from '../model/restaurateur';
import { Observable } from 'rxjs';
import { ObjectToJsonService } from './object-to-json.service';

@Injectable({
  providedIn: 'root',
})
export class RestaurateurService {
  constructor(
    private httpClient: HttpClient,
    private convert: ObjectToJsonService
  ) {}

  public allClient(): Observable<Restaurateur[]> {
    return this.httpClient.get<Restaurateur[]>(
      'http://localhost:8080/projetFinal/api/client'
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/eshop/api/client/${id}`
    );
  }

  public create(restaurateur: Restaurateur): Observable<Restaurateur> {
    console.debug(restaurateur);
    return this.httpClient.post<Restaurateur>(
      'http://localhost:8080/eshop/api/client/inscription',
      this.convert.restaurateurToJson(restaurateur)
    );
  }

  public update(restaurateur: Restaurateur): Observable<Restaurateur> {
    return this.httpClient.put<Restaurateur>(
      `http://localhost:8080/eshop/api/client/${restaurateur.id}`,
      this.convert.restaurateurToJson(restaurateur)
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
