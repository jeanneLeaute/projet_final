import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ObjectToJsonService } from './object-to-json.service';
import { Observable } from 'rxjs';
import { Utilisateur } from '../model/utilisateur';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  constructor(
    private httpClient: HttpClient,
    private convert: ObjectToJsonService
  ) {}

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/projetFinal/api/admin/${id}`
    );
  }

  public getById(id: number): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(
      `http://localhost:8080/projetFinal/api/admin/${id}`
    );
  }
}
