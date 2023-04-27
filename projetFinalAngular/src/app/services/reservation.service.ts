import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reservation } from '../model/reservation';
import { ObjectToJsonService } from './object-to-json.service';
import { SurPlace } from '../model/sur-place';
import { CommandeADomicileService } from './commande-adomicile.service';
import { CommandeADomicile } from '../model/commande-adomicile';

@Injectable({
  providedIn: 'root',
})
export class ReservationService {
  private url: string = 'http://localhost:8080/projetfinal/api/reservation';

  constructor(
    private httpClient: HttpClient,
    private convert: ObjectToJsonService
  ) {}

  public allReservation(): Observable<Reservation[]> {
    return this.httpClient.get<Reservation[]>(
      'http://localhost:8080/projetfinal/api/reservation'
    );
  }

  public getById(id: number): Observable<Reservation> {
    return this.httpClient.get<Reservation>(`${this.url}/${id}`);
  }

  public getSurPlaceByRestaurant(id: number): Observable<SurPlace[]> {
    return this.httpClient.get<SurPlace[]>(
      `http://localhost:8080/projetFinal/api/SurPlace/restau-reservation/${id}`
    );
  }

  public getCommandeByRestaurant(id: number): Observable<CommandeADomicile[]> {
    return this.httpClient.get<CommandeADomicile[]>(
      `http://localhost:8080/projetFinal/api/CommandeADomicile/restau-reservation/${id}`
    );
  }

  public getSurPlaceByClient(id: number): Observable<SurPlace[]> {
    return this.httpClient.get<SurPlace[]>(
      `http://localhost:8080/projetFinal/api/SurPlace/client-reservation/${id}`
    );
  }

  public getCommandeByClient(id: number): Observable<CommandeADomicile[]> {
    return this.httpClient.get<CommandeADomicile[]>(
      `http://localhost:8080/projetFinal/api/CommandeADomicile/client-reservation/${id}`
    );
  }
}
