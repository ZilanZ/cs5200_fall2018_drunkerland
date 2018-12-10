import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {WineCardComponent} from './wine-card.component';
import {WineService} from '../../../modules/wines/shared/wine.service';
import {APP_CONFIG, AppConfig} from '../../../configs/app.config';
import {CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import {APP_BASE_HREF} from '@angular/common';
import {TestsModule} from '../../modules/tests.module';
import {Wine} from '../../../modules/wines/shared/wine.model';
import {TranslateModule} from '@ngx-translate/core';

describe('WineCardComponent', () => {
  let component: WineCardComponent;
  let fixture: ComponentFixture<WineCardComponent>;

  beforeEach((() => {
    TestBed.configureTestingModule({
      imports: [
        TestsModule,
        TranslateModule.forRoot()
      ],
      declarations: [
        WineCardComponent
      ],
      providers: [
        {provide: APP_CONFIG, useValue: AppConfig},
        {provide: APP_BASE_HREF, useValue: '/'},
        WineService
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WineCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should like a wine', () => {
    localStorage.setItem('votes', String(AppConfig.votesLimit - 1));
    const wine = new Wine({likes: 1});
    wine.like();
    expect(wine.likes).toBe(2);
  });

  it('should not like a wine', () => {
    localStorage.setItem('votes', String(AppConfig.votesLimit));
    expect(WineService.checkIfUserCanVote()).toBe(false);
  });
});
