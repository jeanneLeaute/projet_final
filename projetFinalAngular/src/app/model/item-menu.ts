import { Restaurant } from "./restaurant";

export class ItemMenu {
  public constructor(
    _urlImage:string,
    _nom:string,
    _description:string,
    _categoriePlat:string,
    _restaurant:Restaurant) {}

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
