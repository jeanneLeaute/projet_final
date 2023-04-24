import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ObjectToJsonService } from './object-to-json.service';
import { Restaurant } from '../model/restaurant';
import { Categorie } from '../model/categorie';

@Injectable({
  providedIn: 'root',
})
export class RestaurantService {
  constructor(
    private httpClient: HttpClient,
    private convert: ObjectToJsonService
  ) {}

  public allRestaurant(): Observable<Restaurant[]> {
    return this.httpClient.get<Restaurant[]>(
      `http://localhost:8080/projetFinal/api/restaurant`
    );
  }

  public getById(id: number): Observable<Restaurant> {
    return this.httpClient.get<Restaurant>(
      `http://localhost:8080/projetFinal/api/restaurant/${id}`
    );
  }

  public getByIdWithRestaurateur(id: number): Observable<Restaurant> {
    return this.httpClient.get<Restaurant>(
      `http://localhost:8080/projetFinal/api/restaurant/${id}$/restaurateur`
    );
  }

  public getByIdWithItemsMenu(id: number): Observable<Restaurant> {
    return this.httpClient.get<Restaurant>(
      `http://localhost:8080/projetFinal/api/restaurant/${id}$/itemMenu`
    );
  }

  public getByIdWithCommentaire(id: number): Observable<Restaurant> {
    return this.httpClient.get<Restaurant>(
      `http://localhost:8080/projetFinal/api/restaurant/${id}$/commentaires`
    );
  }

  public getByVille(ville: String): Observable<Restaurant[]> {
    return this.httpClient.get<Restaurant[]>(
      `http://localhost:8080/projetFinal/api/restaurant/${ville}`
    );
  }

  public getByCategories(categorie: Categorie): Observable<Restaurant[]> {
    return this.httpClient.get<Restaurant[]>(
      `http://localhost:8080/projetFinal/api/restaurant/${categorie}`
    );
  }

  public getByCategoriesAndVille(
    categorie: Categorie,
    ville: String
  ): Observable<Restaurant[]> {
    return this.httpClient.get<Restaurant[]>(
      `http://localhost:8080/projetFinal/api/restaurant/${categorie}/${ville}`
    );
  }

  public create(restaurant: Restaurant): Observable<Restaurant> {
    return this.httpClient.post<Restaurant>(
      'http://localhost:8080/projetFinal/api/restaurant',
      this.convert.restaurantToJson(restaurant)
    );
  }

  public update(restaurant: Restaurant): Observable<Restaurant> {
    return this.httpClient.put<Restaurant>(
      `http://localhost:8080/projetFinal/api/restaurant/${restaurant.id}`,
      this.convert.restaurantToJson(restaurant)
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/projetFinal/api/restaurant/${id}`
    );
  }
}
