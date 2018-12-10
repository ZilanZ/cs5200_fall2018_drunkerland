import { ErrorHandler, NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { CoreModule } from './core/core.module';
import { AppComponent } from './app.component';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { ServiceWorkerModule } from '@angular/service-worker';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { environment } from '../environments/environment';
import { WebpackTranslateLoader } from './webpack-translate-loader';
import { APP_CONFIG, AppConfig } from './configs/app.config';
import { SharedModule } from './shared/shared.module';
import { NgxExampleLibraryModule } from '@ismaestro/ngx-example-library';
import { FirebaseModule } from './shared/modules/firebase.module';
import { SentryErrorHandler } from './core/sentry.errorhandler';
import {WineServiceClient} from '../services/wine.service.client';

@NgModule({
  imports: [
    BrowserModule,
    FirebaseModule,
    ServiceWorkerModule.register('/ngsw-worker.js', { enabled: environment.production }),
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useClass: WebpackTranslateLoader
      }
    }),
    NgxExampleLibraryModule.forRoot({
      config: {
        say: 'hello'
      }
    }),
    CoreModule,
    SharedModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  declarations: [
    AppComponent
  ],
  providers: [
    WineServiceClient,
    { provide: APP_CONFIG, useValue: AppConfig },
    { provide: ErrorHandler, useClass: SentryErrorHandler }
  ],
  bootstrap: [AppComponent]
})

export class AppModule {
}
