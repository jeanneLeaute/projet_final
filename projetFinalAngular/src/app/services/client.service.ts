import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ObjectToJsonService } from './object-to-json.service';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
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

  public create(client: Utilisateur): Observable<Utilisateur> {
    console.debug(client);
    return this.httpClient.post<Utilisateur>(
      'http://localhost:8080/eshop/api/client/inscription',
      this.convert.utilisateurToJson(client)
    );
  }

  public update(client: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.put<Utilisateur>(
      `http://localhost:8080/eshop/api/client/${client.id}`,
      this.convert.utilisateurToJson(client)
    );
  }

  public getById(id: number): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(
      `http://localhost:8080/eshop/api/client/${id}`
    );
  }

  public getByLogin(login: string): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(
      `http://localhost:8080/eshop/api/client/${login}`
    );
  }
}
