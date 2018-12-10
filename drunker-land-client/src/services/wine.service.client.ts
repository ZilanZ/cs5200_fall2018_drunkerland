import {mainUrl} from './common';
import {Injectable} from '@angular/core';

@Injectable()
export class WineServiceClient {
  private wineUrl = mainUrl + '/rest/api/wines';

  constructor(
  ) { }
  //
  // getWines(): Observable<Wine[]> {
  //   return this.http.get<Wine[]>(this.wineUrl);
  // }
  //
  getWineById = id => {
    fetch(this.wineUrl + '/' + id)
      .then(res => res.json());
  }

  getWinesByName = name =>
    fetch(this.wineUrl + '/name/' + name)
      .then(res => res.json())

  getWinesByVintage = vintage =>
    fetch(this.wineUrl + '/vintage/' + vintage)
      .then(res => res.json())

  getWinesByColor = color =>
    fetch(this.wineUrl + '/color/' + color)
      .then(res => res.json())

  getWinesByRegion = region =>
    fetch(this.wineUrl + '/region/' + region)
      .then(res => res.json())

  getWinesByAppellation = appellation =>
    fetch(this.wineUrl + '/appellation/' + appellation)
      .then(res => res.json())

  getWinesByCountry = country =>
    fetch(this.wineUrl + '/country/' + country)
      .then(res => res.json())
}

