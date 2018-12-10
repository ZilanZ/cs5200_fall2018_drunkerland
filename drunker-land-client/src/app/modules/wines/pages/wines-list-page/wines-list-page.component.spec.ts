import {async, TestBed} from '@angular/core/testing';
import {APP_BASE_HREF} from '@angular/common';
import {WinesModule} from '../../wines.module';
import {TestsModule} from '../../../../shared/modules/tests.module';
import {TranslateModule} from '@ngx-translate/core';
import {WineService} from '../../shared/wine.service';
import {APP_CONFIG, AppConfig} from '../../../../configs/app.config';
import {WinesListPageComponent} from './wines-list-page.component';

describe('WineListComponent', () => {
  let fixture;
  let component;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        TestsModule,
        TranslateModule.forRoot(),
        WinesModule
      ],
      providers: [
        {provide: APP_CONFIG, useValue: AppConfig},
        {provide: APP_BASE_HREF, useValue: '/'},
        WineService
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(WinesListPageComponent);
    fixture.detectChanges();
    component = fixture.debugElement.componentInstance;
  }));

  it('should create wine list component', (() => {
    expect(component).toBeTruthy();
  }));
});
