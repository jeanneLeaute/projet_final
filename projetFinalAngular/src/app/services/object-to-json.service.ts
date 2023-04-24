import { Injectable } from '@angular/core';
import { Client } from '../model/client';
import { Restaurant } from '../model/restaurant';
import { Utilisateur } from '../model/utilisateur';
import { Reservation } from '../model/reservation';

@Injectable({
  providedIn: 'root',
})
export class ObjectToJsonService {
  constructor() {}

  public clientToJson(client: Client): any {
    let obj = {
      nom: client.nom,
      prenom: client.prenom,
      login: client.login,
      password: client.password,
      role: client.role,
    };
    if (client.id) {
      Object.assign(obj, { id: client.id });
    }
    return obj;
  }

  public utilisateurToJson(utilisateur: Utilisateur): any {
    let obj = {
      nom: utilisateur.nom,
      prenom: utilisateur.prenom,
      login: utilisateur.login,
      password: utilisateur.password,
      role: utilisateur.role,
    };
    if (utilisateur.id) {
      Object.assign(obj, { id: utilisateur.id });
    }
    return obj;
  }

  public reservationToJson(reservation: Reservation): any {
    let obj = {
      client: reservation.client,
      restaurant: reservation.restaurant,
      date: reservation.date,
      specification: reservation.specification,
    };
    if (reservation.id) {
      Object.assign(obj, { id: reservation.id });
    }
    return obj;
  }

  public restaurantToJson(restaurant: Restaurant): any {
    let obj = {
      nom: restaurant.nom,
      description: restaurant.description,
      horaireOuverture: restaurant.horaireOuverture,
      urlImage: restaurant.urlImage,
      aEmporter: restaurant.aEmporter,
      peutReserver: restaurant.peutReserver,
      categories: restaurant.categories,
      restaurateur: restaurant.restaurateur,
      adresse: {
        numero: restaurant.adresse?.numero,
        rue: restaurant.adresse?.rue,
        codePostal: restaurant.adresse?.codePostal,
        ville: restaurant.adresse?.ville,
      },
    };
    if (restaurant.id) {
      Object.assign(obj, { id: restaurant.id });
    }
    return obj;
  }
}