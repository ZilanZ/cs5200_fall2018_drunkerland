import {WinesListPage} from './wines-list-page';
import {browser} from 'protractor';

describe('Wines list page', function () {
  let page;

  beforeEach(() => {
    page = new WinesListPage();
  });

  it('should contains equal or more wines than default ones', () => {
    WinesListPage.navigateTo();
    browser.driver.sleep(2000);
    expect<any>(WinesListPage.getNumberWines()).toBeGreaterThanOrEqual(8);
  });
});
