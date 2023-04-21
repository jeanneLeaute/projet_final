export class Reservation {
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
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
  public set restaurant(value: Restaurant | undefined) {
    this._restaurant = value;
  }

  public get date(): Date | undefined {
    return this._date;
  }
  public set date(value: Date | undefined) {
    this._date = value;
  }

  public get specification(): string | undefined {
    return this._specification;
  }
  public set specification(value: string | undefined) {
    this._specification = value;
  }

  public constructor(
    private _id?: number,
    private _client?: Client,
    private _restaurant?: Restaurant,
    private _date?: Date,
    private _specification?: string
  ) {}

}
