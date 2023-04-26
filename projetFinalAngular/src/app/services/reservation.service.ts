import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reservation } from '../model/reservation';
import { ObjectToJsonService } from './object-to-json.service';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private url: string = 'http://localhost:8080/projetfinal/api/reservation';

  constructor(private httpClient: HttpClient, private convert: ObjectToJsonService) {}

  public allReservation(): Observable<Reservation[]> {
    return this.httpClient.get<Reservation[]>(
      'http://localhost:8080/projetfinal/api/reservation'
    );
  }

  public getById(id: number): Observable<Reservation> {
    return this.httpClient.get<Reservation>(`${this.url}/${id}`);
  }


}
