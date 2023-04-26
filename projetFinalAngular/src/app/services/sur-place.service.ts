import { SurPlace } from './../model/sur-place';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ObjectToJsonService } from './object-to-json.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SurPlaceService {

  private url: string = 'http://localhost:8080/projetFinal/api/SurPlace';

  constructor(private httpClient: HttpClient, private convert: ObjectToJsonService) { }

  public create(surPlace: SurPlace): Observable<SurPlace> {
    console.debug(surPlace);
    return this.httpClient.post<SurPlace>(
      this.url,
      this.convert.surPlaceToJson(surPlace)
    );
  }

  public update(surPlace: SurPlace): Observable<SurPlace> {
    return this.httpClient.put<SurPlace>(
      `${this.url}/${surPlace.id}`,
      this.convert.surPlaceToJson(surPlace)
    );
  }

  public allSurPlace(): Observable<SurPlace[]> {
    return this.httpClient.get<SurPlace[]>(
      this.url,
    );
  }

  public getById(id: number): Observable<SurPlace> {
    return this.httpClient.get<SurPlace>(`${this.url}/${id}`);
  }
}
