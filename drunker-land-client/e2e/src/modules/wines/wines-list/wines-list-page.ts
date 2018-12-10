import {browser, by, element} from 'protractor';
import {AppConfig} from '../../../../../src/app/configs/app.config';

export class WinesListPage {
  static navigateTo(): any {
    return browser.get(AppConfig.routes.wines);
  }

  static getNumberWines(): any {
    return element.all(by.css('#left mat-list-item')).count();
  }
}
