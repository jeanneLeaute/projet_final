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

  constructor(private http: HttpClient, private convert: ObjectToJsonService) {}

  public allReservation(): Observable<Reservation[]> {
    return this.httpClient.get<Reservation[]>(
      'http://localhost:8080/projetfinal/api/reservation'
    );
  }

  public create(reservation: Reservation): Observable<Reservation> {
    console.debug(reservation);
    return this.httpClient.post<Reservation>(
      this.url,
      this.convert.reservationToJson(reservation)
    );
  }

  public update(reservation: Reservation): Observable<Reservation> {
    return this.httpClient.put<Reservation>(
      `${this.url}/${reservation.id}`,
      this.convert.reservationToJson(reservation)
    );
  }

  public getById(id: number): Observable<Reservation> {
    return this.httpClient.get<Reservation>(`${this.url}/${id}`);
  }


}
