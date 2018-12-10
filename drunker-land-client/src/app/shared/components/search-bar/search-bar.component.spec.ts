import {fakeAsync, TestBed, tick} from '@angular/core/testing';
import {SearchBarComponent} from './search-bar.component';
import {CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import {TranslateModule} from '@ngx-translate/core';
import {AppRoutingModule} from '../../../app-routing.module';
import {APP_BASE_HREF} from '@angular/common';
import {TestsModule} from '../../modules/tests.module';
import {WineService} from '../../../modules/wines/shared/wine.service';
import {Router} from '@angular/router';
import {Wine} from '../../../modules/wines/shared/wine.model';
import {HomePageComponent} from '../../pages/home-page/home-page.component';
import {Error404PageComponent} from '../../pages/error404-page/error404-page.component';
import {APP_CONFIG, AppConfig} from '../../../configs/app.config';
import {of} from 'rxjs';

describe('WineSearchComponent', () => {
  let fixture;
  let component;
  let wineService;

  beforeEach((() => {
    TestBed.configureTestingModule({
      imports: [
        TestsModule,
        TranslateModule.forRoot(),
        AppRoutingModule
      ],
      declarations: [
        SearchBarComponent,
        HomePageComponent,
        Error404PageComponent
      ],
      providers: [
        {
          provide: Router,
          useClass: class {
            navigate = jasmine.createSpy('navigate');
          }
        },
        {provide: APP_CONFIG, useValue: AppConfig},
        {provide: APP_BASE_HREF, useValue: '/'},
        WineService
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    }).compileComponents();

    fixture = TestBed.createComponent(SearchBarComponent);
    component = fixture.debugElement.componentInstance;
    wineService = TestBed.get(WineService);
  }));

  it('should create wine search component', (() => {
    fixture.detectChanges();
    expect(component).toBeTruthy();
  }));

  it('should get all wines', fakeAsync(() => {
    spyOn(wineService, 'getWines').and.returnValue(of([new Wine({name: 'test1', default: true})]));
    fixture.detectChanges();
    tick();

    expect(component.defaultWines.length).toBeGreaterThan(0);
    for (const wine of component.defaultWines) {
      expect(wine.default).toBe(true);
    }
  }));

  it('should filter wines array', (() => {
    fixture.detectChanges();

    component.defaultWines = [
      {
        'id': 1,
        'name': 'batman',
        'default': true
      },
      {
        'id': 2,
        'name': 'spiderman',
        'default': false
      }
    ];
    expect(component.filterWines('batman').length).toBe(1);
    expect(component.filterWines('spiderman').length).toBe(0);
    expect(component.filterWines().length).toBe(2);
  }));

  it('should navigate to wine detail', (() => {
    fixture.detectChanges();

    const wineId = 'BzTvl77YsRTtdihH0jeh';
    const router = fixture.debugElement.injector.get(Router);
    component.searchWine(new Wine({id: wineId}));
    expect(router.navigate).toHaveBeenCalledWith(['wines/' + wineId]);
  }));
});
