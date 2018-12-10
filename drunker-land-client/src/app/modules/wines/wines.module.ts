import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {WineRoutingModule} from './wines-routing.module';
import {SharedModule} from '../../shared/shared.module';
import {WineRemoveComponent} from './components/wine-remove/wine-remove.component';
import {WinesListPageComponent} from './pages/wines-list-page/wines-list-page.component';
import {WineDetailPageComponent} from './pages/wine-detail-page/wine-detail-page.component';

@NgModule({
  imports: [
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
    WineRoutingModule,
  ],
  declarations: [
    WinesListPageComponent,
    WineDetailPageComponent,
    WineRemoveComponent
  ],
  entryComponents: [
    WineRemoveComponent
  ]
})

export class WinesModule {
}
