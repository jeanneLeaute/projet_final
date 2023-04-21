import { Injectable } from '@angular/core';
import { Client } from '../model/client';
import { Restaurateur } from '../model/restaurateur';

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

  public restaurateurToJson(restaurateur: Restaurateur): any {
    let obj = {
      nom: restaurateur.nom,
      prenom: restaurateur.prenom,
      login: restaurateur.login,
      password: restaurateur.password,
      role: restaurateur.role,
    };
    if (restaurateur.id) {
      Object.assign(obj, { id: restaurateur.id });
    }
    return obj;
  }
}
