import {InjectionToken} from '@angular/core';

export let APP_CONFIG = new InjectionToken('app.config');

export const AppConfig: any = {
  routes: {
    login: 'login',
    register: 'register',
    wines: 'wines',
    error404: '404'
  },
  votesLimit: 3,
  topWinesLimit: 100,
  snackBarDuration: 3000,
  repositoryURL: '',
  sentryDSN: '',
  backendURL: 'http://localhost:8080',
  externalServiceURL: 'https://www.globalwinescore.com'
};
