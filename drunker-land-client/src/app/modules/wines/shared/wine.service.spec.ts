import {async, TestBed} from '@angular/core/testing';
import {WineService} from './wine.service';
import {APP_BASE_HREF} from '@angular/common';
import {TestsModule} from '../../../shared/modules/tests.module';
import {TranslateModule} from '@ngx-translate/core';
import {APP_CONFIG, AppConfig} from '../../../configs/app.config';
import {Wine} from './wine.model';
import {HttpErrorResponse} from '@angular/common/http';

describe('WineService', () => {
  const wineId = 'BzTvl77YsRTtdihH0jeh';
  let wineService: WineService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        TestsModule,
        TranslateModule.forRoot()
      ],
      providers: [
        {provide: APP_CONFIG, useValue: AppConfig},
        {provide: APP_BASE_HREF, useValue: '/'},
        WineService
      ]
    });

    wineService = TestBed.get(WineService);
  });

  it('should get wine by id ' + wineId, (() => {
    wineService.getWine(wineId).subscribe((wine: Wine) => {
      expect(wine.id).toEqual(wineId);
    });
  }));

  it('should fail getting wine by no id', (() => {
    wineService.getWine('noId').subscribe(() => {
    }, (error) => {
      expect(error).toEqual(jasmine.any(HttpErrorResponse));
    });
  }));

  it('should fail creating empty wine', (() => {
    wineService.createWine(new Wine({
      'name': 'test',
      'alterEgo': 'test'
    })).then(() => {
    }, (error) => {
      expect(error).toEqual(jasmine.any(HttpErrorResponse));
    });
  }));

});
