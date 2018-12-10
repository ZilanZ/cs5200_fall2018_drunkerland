import {TestBed} from '@angular/core/testing';
import {APP_BASE_HREF} from '@angular/common';
import {WinesModule} from '../../wines.module';
import {TestsModule} from '../../../../shared/modules/tests.module';
import {TranslateModule} from '@ngx-translate/core';
import {WineService} from '../../shared/wine.service';
import {ActivatedRoute, convertToParamMap} from '@angular/router';
import {APP_CONFIG, AppConfig} from '../../../../configs/app.config';
import {WineDetailPageComponent} from './wine-detail-page.component';

describe('WineDetailPage', () => {
  let fixture;
  let component;
  let wineService;

  beforeEach((() => {
    TestBed.configureTestingModule({
      imports: [
        TestsModule,
        TranslateModule.forRoot(),
        WinesModule
      ],
      providers: [
        {provide: APP_CONFIG, useValue: AppConfig},
        {provide: APP_BASE_HREF, useValue: '/'},
        {
          provide: ActivatedRoute,
          useValue: {
            snapshot: {
              paramMap: convertToParamMap({
                id: 'BzTvl77YsRTtdihH0jeh'
              })
            }
          }
        },
        WineService
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(WineDetailPageComponent);
    fixture.detectChanges();
    component = fixture.debugElement.componentInstance;
    wineService = TestBed.get(WineService);
  }));

  it('should create wine detail component', (() => {
    expect(component).toBeTruthy();
  }));
});
