import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ObjectToJsonService } from './object-to-json.service';
import { Observable } from 'rxjs';
import { ItemMenu } from '../model/item-menu';
import { Restaurant } from '../model/restaurant';

@Injectable({
  providedIn: 'root'
})
export class ItemMenuService {
  constructor(
    private httpClient: HttpClient,
    private convert: ObjectToJsonService
  ) {}

  public allItemMenu(): Observable<ItemMenu[]> {
    return this.httpClient.get<ItemMenu[]>(
      'http://localhost:8080/projetFinal/api/itemMenu'
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/projetFinal/api/ItemMenu/${id}`
    );
  }

  public create(item: ItemMenu): Observable<ItemMenu> {
    console.debug(item);
    return this.httpClient.post<ItemMenu>(
      'http://localhost:8080/projetFinal/api/ItemMenu/creation',
      this.convert.itemMenuToJson(item)
    );
  }

  public update(item: ItemMenu): Observable<ItemMenu> {
    return this.httpClient.put<ItemMenu>(
      `http://localhost:8080/projetFinal/api/itemMenu/${item.id_item}`,
      this.convert.itemMenuToJson(item)
    );
  }

  public getById(id: number): Observable<ItemMenu> {
    return this.httpClient.get<ItemMenu>(
      `http://localhost:8080/projetFinal/api/itemMenu/${id}`
    );
  }

  public findByRestaurant(restau:Restaurant):Observable<ItemMenu[]>{
    return this.httpClient.get<ItemMenu[]>(
      `http://localhost:8080/projetFinal/api/itemMenu/${restau.id}/restaurant`
    );
  }
}
