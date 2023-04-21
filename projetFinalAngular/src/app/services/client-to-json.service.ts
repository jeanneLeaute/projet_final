import { Injectable } from '@angular/core';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root',
})
export class ClientToJsonService {
  constructor() {}

  public ToJson(client: Client): any {
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
}
