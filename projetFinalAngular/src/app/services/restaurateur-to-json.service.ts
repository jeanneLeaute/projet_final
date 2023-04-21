import { Injectable } from '@angular/core';
import { Restaurateur } from '../model/restaurateur';

@Injectable({
  providedIn: 'root',
})
export class RestaurateurToJsonService {
  constructor() {}

  public ToJson(restaurateur: Restaurateur): any {
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
