import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Client } from '../model/client';
import { Observable } from 'rxjs';
import { ObjectToJsonService } from './object-to-json.service';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  constructor(
    private httpClient: HttpClient,
    private convert: ObjectToJsonService
  ) {}

  public allClient(): Observable<Client[]> {
    return this.httpClient.get<Client[]>(
      'http://localhost:8080/projetFinal/api/client'
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/eshop/api/client/${id}`
    );
  }

  public create(client: Client): Observable<Client> {
    console.debug(client);
    return this.httpClient.post<Client>(
      'http://localhost:8080/eshop/api/client/inscription',
      this.convert.clientToJson(client)
    );
  }

  public update(client: Client): Observable<Client> {
    return this.httpClient.put<Client>(
      `http://localhost:8080/eshop/api/client/${client.id}`,
      this.convert.clientToJson(client)
    );
  }

  public getById(id: number): Observable<Client> {
    return this.httpClient.get<Client>(
      `http://localhost:8080/eshop/api/client/${id}`
    );
  }

  public getByLogin(login: string): Observable<Client> {
    return this.httpClient.get<Client>(
      `http://localhost:8080/eshop/api/client/${login}`
    );
  }
}
