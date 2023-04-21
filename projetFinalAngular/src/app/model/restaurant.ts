import { Adresse } from './adresse';
import { Categorie } from './categorie';
import { Restaurateur } from './restaurateur';

export class Restaurant {
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public get description(): string | undefined {
    return this._description;
  }
  public set description(value: string | undefined) {
    this._description = value;
  }
  public get horaireOuverture(): string | undefined {
    return this._horaireOuverture;
  }
  public set horaireOuverture(value: string | undefined) {
    this._horaireOuverture = value;
  }
  public get urlImage(): string | undefined {
    return this._urlImage;
  }
  public set urlImage(value: string | undefined) {
    this._urlImage = value;
  }
  public get aEmporter(): boolean | undefined {
    return this._aEmporter;
  }
  public set aEmportern(value: boolean | undefined) {
    this._aEmporter = value;
  }
  public get peutResrver(): boolean | undefined {
    return this._peutResrver;
  }
  public set peutResrver(value: boolean | undefined) {
    this._peutResrver = value;
  }
  public get categories(): Categorie | undefined {
    return this._categories;
  }
  public set categories(value: Categorie | undefined) {
    this._categories = value;
  }
  public get adresse(): Adresse | undefined {
    return this._adresse;
  }
  public set adressse(value: Adresse | undefined) {
    this._adresse = value;
  }
  public get restaurateur(): Restaurateur | undefined {
    return this._restaurateur;
  }
  public set restaurateur(value: Restaurateur | undefined) {
    this._restaurateur = value;
  }

  public constructor(
    private _id?: number,
    private _nom?: string,
    private _description?: string,
    private _horaireOuverture?: string,
    private _urlImage?: string,
    private _aEmporter?: boolean,
    private _peutResrver?: boolean,
    private _categories?: Categorie,
    private _adresse?: Adresse,
    private _restaurateur?: Restaurateur
  ) {}
}
