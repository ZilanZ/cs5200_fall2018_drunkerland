import {TestBed} from '@angular/core/testing';
import {ProgressBarService} from './progress-bar.service';
import {TestsModule} from '../../shared/modules/tests.module';
import {TranslateModule} from '@ngx-translate/core';
import {WineService} from '../../modules/wines/shared/wine.service';
import {APP_CONFIG, AppConfig} from '../../configs/app.config';

describe('ProgressBarService', () => {
  let progressBarService;
  let wineService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        TestsModule,
        TranslateModule.forRoot(),
      ],
      providers: [
        {provide: APP_CONFIG, useValue: AppConfig},
        ProgressBarService,
        WineService
      ]
    });

    progressBarService = TestBed.get(ProgressBarService);
    wineService = TestBed.get(WineService);
  });

  it('should not be requestsRunning', (() => {
    const instance = new ProgressBarService();
    expect(instance).toBeTruthy();
  }));

  it('should not be requestsRunning', (() => {
    expect(progressBarService.requestsRunning).toBe(0);
  }));

  it('should increase and decrease the counter of requests running', (() => {
    progressBarService.increase();
    progressBarService.increase();
    expect(progressBarService.requestsRunning).toBe(2);
    progressBarService.decrease();
    expect(progressBarService.requestsRunning).toBe(1);
    progressBarService.decrease();
    expect(progressBarService.requestsRunning).toBe(0);
    progressBarService.decrease();
    expect(progressBarService.requestsRunning).toBe(0);
  }));
});
