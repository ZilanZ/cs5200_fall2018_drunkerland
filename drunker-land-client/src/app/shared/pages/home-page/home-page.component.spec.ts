import {async, fakeAsync, TestBed, tick} from '@angular/core/testing';
import {APP_BASE_HREF} from '@angular/common';
import {TranslateModule} from '@ngx-translate/core';
import {CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import {TestsModule} from '../../modules/tests.module';
import {WineService} from '../../../modules/wines/shared/wine.service';
import {HomePageComponent} from './home-page.component';
import {APP_CONFIG, AppConfig} from '../../../configs/app.config';
import {of} from 'rxjs';
import {Wine} from '../../../modules/wines/shared/wine.model';

describe('HomePage', () => {
  let fixture;
  let component;
  let wineService;

  beforeEach((() => {
    TestBed.configureTestingModule({
      imports: [
        TestsModule,
        TranslateModule.forRoot(),
      ],
      declarations: [
        HomePageComponent
      ],
      providers: [
        {provide: APP_CONFIG, useValue: AppConfig},
        {provide: APP_BASE_HREF, useValue: '/'},
        WineService
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    }).compileComponents();

    fixture = TestBed.createComponent(HomePageComponent);
    component = fixture.debugElement.componentInstance;
    wineService = TestBed.get(WineService);
  }));

  it('should create wine top component', (() => {
    fixture.detectChanges();
    expect(component).toBeTruthy();
  }));

  it('should initialice component', fakeAsync(() => {
    const wines = [
      new Wine({name: 'test1', default: true}),
      new Wine({name: 'test2', default: true}),
      new Wine({name: 'test3', default: true}),
      new Wine({name: 'test4', default: true})
    ];
    spyOn(wineService, 'getWines').and.returnValue(of(wines));
    fixture.detectChanges();
    tick();
    expect(component.wines.length).toBe(AppConfig.topWinesLimit);
  }));
});
