import {Component, Inject, Input, OnInit} from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
import {_} from '@biesbjerg/ngx-translate-extract/dist/utils/utils';
import {APP_CONFIG, AppConfig} from '../../../configs/app.config';
import {ProgressBarService} from '../../../core/services/progress-bar.service';
import {LocalStorage} from 'ngx-store';
import {AuthenticationService} from '../../../_services';
import {el} from '@angular/platform-browser/testing/src/browser_util';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})

export class HeaderComponent implements OnInit {

  @LocalStorage() language = 'en';

  appConfig: any;
  menuItems: any[];
  progressBarMode: string;
  currentLang: string;

  log: boolean;
  userRole: string;

  loginUrl: string = '/' + AppConfig.routes.login;
  registerUrl: string = '/' + AppConfig.routes.register;

  constructor(@Inject(APP_CONFIG) appConfig: any,
              private authenticationService: AuthenticationService,
              private progressBarService: ProgressBarService,
              private translateService: TranslateService) {
    this.appConfig = appConfig;
    this.authenticationService.log.subscribe( value => {
      this.log = value;
    });
    // console.log(this.log);
    this.userRole = null;
  }

  ngOnInit() {
    this.currentLang = this.translateService.currentLang;
    this.loadMenus();
    this.progressBarService.updateProgressBar$.subscribe((mode: string) => {
      this.progressBarMode = mode;
    });
  }

  // changeLanguage(language: string): void {
  //   this.translateService.use(language).subscribe(() => {
  //     this.loadMenus();
  //     this.language = language;
  //   });
  // }
  private logout(): void {
    this.authenticationService.logout();
    this.authenticationService.log.next(false);
  }

  private loadMenus(): void {
    switch (this.userRole) {
      //
      default: this.menuItems = [
        {link: '/', name: _('home')},
        {link: '/' + AppConfig.routes.wines, name: _('filter')}
      ];
      break;
    }
  }
}
