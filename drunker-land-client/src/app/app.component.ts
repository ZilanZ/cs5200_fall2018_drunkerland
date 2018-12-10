import {Component, OnInit} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import {Meta, Title} from '@angular/platform-browser';
import {NavigationEnd, Router} from '@angular/router';
import {MatSnackBar} from '@angular/material';
import {_} from '@biesbjerg/ngx-translate-extract/dist/utils/utils';
import {AppConfig} from './configs/app.config';
import {LocalStorage} from 'ngx-store';
import {UtilsHelperService} from './core/services/utils-helper.service';
import {WineServiceClient} from '../services/wine.service.client';

declare const require;
declare const Modernizr;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})

export class AppComponent implements OnInit {

  @LocalStorage() language = 'en';
  isOnline: boolean;

  constructor(private translateService: TranslateService,
              private title: Title,
              private meta: Meta,
              private snackBar: MatSnackBar,
              private router: Router) {
    this.isOnline = navigator.onLine;
  }

  ngOnInit() {
    this.translateService.setDefaultLang('en');
    this.translateService.use(this.language);

    // With this we load the default language in the main bundle (cache busting)
    this.translateService.setTranslation('en', require('../assets/i18n/en.json'));

    this.title.setTitle('Drunker Land');

    this.onEvents();
    this.checkBrowser();
  }

  onEvents() {
    this.router.events.subscribe((event: any) => {
      if (event instanceof NavigationEnd) {
        switch (event.urlAfterRedirects) {
          case '/':
            this.meta.updateTag({
              name: 'description',
              content: 'Drunker Land'
            });
            break;
          case '/' + AppConfig.routes.wines:
            this.title.setTitle('Wines list');
            this.meta.updateTag({
              name: 'description',
              content: 'List of super-wines'
            });
            break;
          case '/' + AppConfig.routes.filter:
            this.title.setTitle('Union Search');
            this.meta.updateTag({
              name: 'description',
              content: 'Union search of wines'
            });
            break;
        }
      }
    });
  }

  checkBrowser() {
    if (UtilsHelperService.isBrowserValid()) {
      this.checkBrowserFeatures();
    } else {
      this.translateService.get([String(_('changeBrowser'))]).subscribe((texts) => {
        this.snackBar.open(texts['changeBrowser'], 'OK');
      });
    }
  }

  checkBrowserFeatures() {
    let supported = true;
    for (const feature in Modernizr) {
      if (Modernizr.hasOwnProperty(feature) &&
        typeof Modernizr[feature] === 'boolean' && Modernizr[feature] === false) {
        supported = false;
        break;
      }
    }

    if (!supported) {
      this.translateService.get([String(_('updateBrowser'))]).subscribe((texts) => {
        this.snackBar.open(texts['updateBrowser'], 'OK');
      });
    }

    return supported;
  }
}
