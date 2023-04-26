import { Client } from "./client";
import { HeureReservation } from "./heure-reservation";
import { ItemMenu } from "./item-menu";
import { Reservation } from "./reservation";
import { Restaurant } from "./restaurant";
import { Utilisateur } from "./utilisateur";

export class SurPlace extends Reservation{
  public get nbPersonne(): number |undefined{
    return this._nbPersonne;
  }
  public set nbPersonne(value: number|undefined) {
    this._nbPersonne = value;
  }
  public get heureReservation(): HeureReservation | undefined{
    return this._heureReservation;
  }
  public set heureReservation(value: HeureReservation| undefined) {
    this._heureReservation = value;
  }
  public get itemsMenu(): ItemMenu[] | undefined {
    return this._itemsMenu;
  }
  public set itemsMenu(value: ItemMenu[]| undefined) {
    this._itemsMenu = value;
  }
  public get choixTables(): string | undefined{
    return this._choixTables;
  }
  public set choixTables(value: string| undefined) {
    this._choixTables = value;
  }


  constructor(
    _id?:number,
    _client?: Utilisateur,
    _restaurant?: Restaurant,
    _date?: Date,
    _specification?: string,
    private _nbPersonne?: number,
    private _choixTables?: string,
    private _itemsMenu?: ItemMenu[],
    private _heureReservation?: HeureReservation
  ) {
    super(_id,_client,
      _restaurant,
      _date,
      _specification);
  }
}
