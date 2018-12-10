import {Injectable} from '@angular/core';
import {AngularFirestore, AngularFirestoreCollection} from '@angular/fire/firestore';
import { HttpClient } from '@angular/common/http';
import {WineQuery} from './wineQuery.model';
import {AppConfig} from '../../../configs/app.config';

@Injectable({
  providedIn: 'root'
})
export class FilterService {

  private wineQueryCollection: AngularFirestoreCollection<WineQuery>;

  constructor(private afs: AngularFirestore,
              private http: HttpClient) {
    this.wineQueryCollection = this.afs.collection<WineQuery>(AppConfig.routes.filter, (wineQuery) =>{
      return wineQuery;
    });
  }
}
