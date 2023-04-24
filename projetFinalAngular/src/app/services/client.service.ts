import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ObjectToJsonService } from './object-to-json.service';
import { Utilisateur } from '../model/utilisateur';
import { Client } from '../model/client';

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
      `http://localhost:8080/projetFinal/api/client/${id}`
    );
  }

  public create(client: Utilisateur): Observable<Utilisateur> {
    console.debug(client);
    return this.httpClient.post<Utilisateur>(
      'http://localhost:8080/projetFinal/api/client/inscription',
      this.convert.utilisateurToJson(client)
    );
  }

  public update(client: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.put<Utilisateur>(
      `http://localhost:8080/projetFinal/api/client/${client.id}`,
      this.convert.utilisateurToJson(client)
    );
  }

  public getById(id: number): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(
      `http://localhost:8080/projetFinal/api/client/${id}`
    );
  }

  public getByLogin(login: string): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(
      `http://localhost:8080/projetFinal/api/client/${login}`
    );
  }

  public inscription(client: any): Observable<any> {
    return this.httpClient.post('http://localhost:8080/projetFinal/api/client//inscription', client);
  }

  public checkLogin(login: string): Observable<boolean> {
    return this.httpClient.get<boolean>(
      'http://localhost:8080/projetFinal/api/client/login/check/' + login
    );
  }
}
