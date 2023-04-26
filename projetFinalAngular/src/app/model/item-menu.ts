import { Restaurant } from "./restaurant";

export class ItemMenu {
  selected: unknown;
  public constructor(
    _id_item:number,
    _urlImage:string,
    _nom:string,
    _description:string,
    _categoriePlat:string,
    _restaurant:Restaurant) {}

    public get id_item(): number{
      return this.id_item;
    }
    public set id_item(value: number) {
      this.id_item = value;
    }

    public get urlImage(): string{
      return this.urlImage;
    }
    public set urlImage(value: string) {
      this.urlImage = value;
    }

    public get nom(): string{
      return this.nom;
    }
    public set nom(value: string) {
      this.nom = value;
    }

    public get description(): string{
      return this.description;
    }
    public set description(value: string) {
      this.description = value;
    }

    public get categoriePlat(): string{
      return this.categoriePlat;
    }
    public set categoriePlat(value: string) {
      this.categoriePlat = value;
    }

    public get restaurant(): Restaurant{
      return this.restaurant;
    }
    public set restaurant(value: Restaurant) {
      this.restaurant = value;
    }
}
