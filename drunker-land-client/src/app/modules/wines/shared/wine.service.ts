import {Observable, of, from} from 'rxjs';
import {Injectable} from '@angular/core';
import {Wine} from './wine.model';
import {catchError, map, tap} from 'rxjs/operators';
import {MatSnackBar, MatSnackBarConfig} from '@angular/material';
import {TranslateService} from '@ngx-translate/core';
import {_} from '@biesbjerg/ngx-translate-extract/dist/utils/utils';
import {LoggerService} from '../../../core/services/logger.service';
import {AppConfig} from '../../../configs/app.config';
import {AngularFirestore, AngularFirestoreCollection, DocumentReference} from '@angular/fire/firestore';
import { HttpClient } from '../../../../../node_modules/@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WineService {
  private winesCollection: AngularFirestoreCollection<Wine>;

  static checkIfUserCanVote(): boolean {
    return Number(localStorage.getItem('votes')) < AppConfig.votesLimit;
  }

  constructor(private afs: AngularFirestore,
              private translateService: TranslateService,
              private snackBar: MatSnackBar,
              private http: HttpClient) {
    this.winesCollection = this.afs.collection<Wine>(AppConfig.routes.wines, (wine) => {
      return wine.orderBy('default', 'desc').orderBy('likes', 'desc');
    });
  }

  private static handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      LoggerService.log(`${operation} failed: ${error.message}`);

      if (error.status >= 500) {
        throw error;
      }

      return of(result as T);
    };
  }

  getWines(): Observable<Wine[]> {
    return this.http.get<Wine[]>(AppConfig.backendURL + '/rest/api/wines')
      .pipe(
        tap((wine) => {
          LoggerService.log('fetched wines');
          console.log(wine);
        }),
        catchError(WineService.handleError('getWines', []))
      );
  }

  getWine(id: string): Observable<any> {
    return this.afs.doc(`${AppConfig.routes.wines}/${id}`).get().pipe(
      map((wine) => {
        return new Wine({id, ...wine.data()});
      }),
      tap(() => LoggerService.log(`fetched wine ${id}`)),
      catchError(WineService.handleError('getWine', []))
    );
  }

  createWine(wine: Wine): Promise<DocumentReference> {
    return this.winesCollection.add(JSON.parse(JSON.stringify(wine))).then((document: DocumentReference) => {
      LoggerService.log(`added wine w/ id=${document.id}`);
      this.showSnackBar('wineCreated');
      return document;
    }, (error) => {
      WineService.handleError<any>('createWine', error);
      return error;
    });
  }

  updateWine(wine: Wine): Promise<void> {
    return this.afs.doc(`${AppConfig.routes.wines}/${wine.id}`).update(JSON.parse(JSON.stringify(wine))).then(() => {
      LoggerService.log(`updated wine w/ id=${wine.id}`);
      this.showSnackBar('saved');
    });
  }

  deleteWine(id: string): Promise<void> {
    return this.afs.doc(`${AppConfig.routes.wines}/${id}`).delete();
  }

  showSnackBar(name): void {
    this.translateService.get([String(_('wineCreated')), String(_('saved')),
      String(_('wineLikeMaximum')), String(_('wineRemoved'))], {'value': AppConfig.votesLimit}).subscribe((texts) => {
      const config: any = new MatSnackBarConfig();
      config.duration = AppConfig.snackBarDuration;
      this.snackBar.open(texts[name], 'OK', config);
    });
  }
}
