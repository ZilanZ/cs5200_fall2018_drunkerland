import {Deserializable} from '../../../shared/interfaces/deserializable.interface';

export class WineQuery implements Deserializable {
  name: String;
  appellation: String;
  color: String;
  region: String;
  country: String;
  vintage: String;
  leastDate: Date;
  greaterDate: Date;
  primeurs: Boolean;
  leastScore: Number;
  greaterScore: Number;
  supplier: String;

  constructor(wineQuery: any = {}) {
    this.name = wineQuery.name;
    this.appellation = wineQuery.appellation;
    this.color = wineQuery.color;
    this.region = wineQuery.region;
    this.country = wineQuery.country;
    this.vintage = wineQuery.vintage;
    this.leastDate = wineQuery.leastDate;
    this.greaterDate = wineQuery.greaterDate;
    this.primeurs = wineQuery.primeurs;
    this.leastScore = wineQuery.leastScore;
    this.greaterScore = wineQuery.greaterScore;
    this.supplier = wineQuery.supplier;
  }

  deserialize(input: any): this {
    Object.assign(this, input);
    return this;
  }
}
