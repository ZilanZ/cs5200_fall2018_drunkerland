import {browser, by, element} from 'protractor';

export class HomePage {
  static navigateTo(): any {
    return browser.get('/');
  }

  static getNumberWines(): any {
    return element.all(by.css('#wines-list mat-card')).count();
  }
}
