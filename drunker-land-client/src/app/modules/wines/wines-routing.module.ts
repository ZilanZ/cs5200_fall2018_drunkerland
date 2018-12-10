import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {WinesListPageComponent} from './pages/wines-list-page/wines-list-page.component';
import {WineDetailPageComponent} from './pages/wine-detail-page/wine-detail-page.component';

const winesRoutes: Routes = [
  {path: '', component: WinesListPageComponent},
  {path: ':id', component: WineDetailPageComponent}
];

@NgModule({
  imports: [
    RouterModule.forChild(winesRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class WineRoutingModule {
}
