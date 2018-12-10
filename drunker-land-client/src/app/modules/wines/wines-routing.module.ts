import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {WinesListPageComponent} from './pages/wines-list-page/wines-list-page.component';
import {WineDetailPageComponent} from './pages/wine-detail-page/wine-detail-page.component';

const wineesRoutes: Routes = [
  {path: '', component: WinesListPageComponent},
  {path: ':id', component: WineDetailPageComponent}
];

@NgModule({
  imports: [
    RouterModule.forChild(wineesRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class WineRoutingModule {
}
