import { Client } from './client';
import { Restaurant } from './restaurant';

export class Commentaire {
  commentaire: any;
  utilisateur: any;
  public get texte(): string | undefined {
    return this._texte;
  }
  public set texte(value: string | undefined) {
    this._texte = value;
  }
  public get client(): Client | undefined {
    return this._client;
  }
  public set client(value: Client | undefined) {
    this._client = value;
  }
  public get restaurant(): Restaurant | undefined {
    return this._restaurant;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set restaurant(value: Restaurant | undefined) {
    this._restaurant = value;
  }
  public constructor(
    private _texte?: string,
    private _client?: Client,
    private _restaurant?: Restaurant,
    private _id?: number
  ) {}
}
