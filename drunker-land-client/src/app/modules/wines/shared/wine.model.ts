import {Deserializable} from '../../../shared/interfaces/deserializable.interface';

export class Wine implements Deserializable {
  id: string;
  name: string;
  alterEgo: string;
  // likes: number;
  default: boolean;
  avatarUrl: string;
  avatarThumbnailUrl: string;

  nameUrl: String;
  appellation: String;
  color: String;
  region: String;
  country: String;
  vintage: String;
  date: Date;
  primeurs: Boolean;
  score: Number;
  supplier: String;
  stocks: string[];
  wineReviewerRelationship: string[];

  constructor(wine: any = {}) {
    this.id = wine.id;
    this.name = wine.name || '';
    this.nameUrl = wine.nameUrl || '';
    this.alterEgo = wine.alterEgo || '';
    // this.likes = wine.likes || 0;
    this.default = wine.default || false;
    this.avatarUrl = wine.avatarUrl || '';
    this.avatarThumbnailUrl = wine.avatarThumbnailUrl || '';
    this.appellation = wine.appellation || '';
    this.color = wine.color || '';
    this.region = wine.region || '';
    this.country = wine.country || '';
    this.vintage = wine.vintage || '';
    this.date = wine.date || '';
    this.primeurs = wine.primeurs || false;
    this.score = wine.score || -1;
    this.supplier = wine.supplier || '';
    this.stocks = wine.stocks || [];
    this.wineReviewerRelationship = wine.wineReviewerRelationship || [];
  }

  // like() {
  //   this.likes += 1;
  //   localStorage.setItem('votes', '' + (Number(localStorage.getItem('votes')) + 1));
  // }

  deserialize(input: any) {
    Object.assign(this, input);
    return this;
  }
}
