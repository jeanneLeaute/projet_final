import { Adresse } from './adresse';
import { HeureReservation } from './heure-reservation';
import { ItemMenu } from './item-menu';
import { Reservation } from './reservation';
import { Restaurant } from './restaurant';
import { Utilisateur } from './utilisateur';

export class CommandeADomicile extends Reservation {
  public get itemsMenu(): ItemMenu[] | undefined {
    return this._itemsMenu;
  }
  public set itemsMenu(value: ItemMenu[] | undefined) {
    this._itemsMenu = value;
  }
  public get adresse(): Adresse {
    return this._adresse;
  }
  public set adresse(value: Adresse) {
    this._adresse = value;
  }

  constructor(
    private _adresse: Adresse,
    _client: Utilisateur,
    _id?: number,
    _restaurant?: Restaurant,
    _date?: Date,
    _specification?: string,
    private _itemsMenu?: ItemMenu[]
  ) {
    super(_client, _id, _restaurant, _date, _specification);
  }
}
