import { HeureReservation } from './../model/heure-reservation';
import { Injectable } from '@angular/core';
import { Client } from '../model/client';
import { Restaurant } from '../model/restaurant';
import { Utilisateur } from '../model/utilisateur';
import { Reservation } from '../model/reservation';
import { ItemMenu } from '../model/item-menu';
import { SurPlace } from '../model/sur-place';
import { CommandeADomicile } from '../model/commande-adomicile';
import { Commentaire } from '../model/commentaire';

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

  public itemMenuToJson(item: ItemMenu): any {
    let obj = {
      nom: item.nom,
      utlImage: item.urlImage,
      categoriePlat: item.categoriePlat,
      description: item.description,
      restaurant: item.restaurant,
    };
    if (item.id_item) {
      Object.assign(obj, { id_item: item.id_item });
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

  public surPlaceToJson(surPlace: SurPlace): any {
    let obj = {
      client: surPlace.client,
      restaurant: surPlace.restaurant,
      date: surPlace.date,
      specification: surPlace.specification,
      nbPersonne: surPlace.nbPersonne,
      choixTables: surPlace.choixTables,
      heureReservation: surPlace.heureReservation,
      itemsMenu: surPlace.itemsMenu,
    };
    if (surPlace.id) {
      Object.assign(obj, { id: surPlace.id });
    }
    return obj;
  }

  public commandeToJson(commande: CommandeADomicile): any {
    let obj = {
      client: commande.client,
      restaurant: commande.restaurant,
      date: commande.date,
      adresse: commande.adresse,
      itemsMenu: commande.itemsMenu,
    };
    if (commande.id) {
      Object.assign(obj, { id: commande.id });
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

  public commentaireToJson(commentaire: Commentaire): any {
    let obj = {
      texte: commentaire.texte,
      client: commentaire.client,
      restaurant: commentaire.restaurant,
    };
    if (commentaire.id) {
      Object.assign(obj, { id: commentaire.id });
    }
    return obj;
  }
}
