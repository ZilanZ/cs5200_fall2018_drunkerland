import { Component, Input, OnInit, Inject } from '@angular/core';
import { APP_CONFIG, AppConfig } from '../../../configs/app.config';
import { WineService } from '../../../modules/wines/shared/wine.service';
import { Wine } from '../../../modules/wines/shared/wine.model';
import { Router } from '@angular/router';
import { validateBasis } from '../../../../../node_modules/@angular/flex-layout';
import {AuthenticationService} from '../../../_services';

@Component({
  selector: 'app-wine-card',
  templateUrl: './wine-card.component.html',
  styleUrls: ['./wine-card.component.scss']
})
export class WineCardComponent implements OnInit {

  @Input() wine: Wine;

  canVote: boolean;
  appConfig: any;
  externalLink: string;
  selectedNum: number;
  options: number[];

  log: boolean;
  userRole: string;

  constructor(private wineService: WineService,
              private authenticationService: AuthenticationService,
              private router: Router,
              @Inject(APP_CONFIG) appConfig: any) {
    this.canVote = WineService.checkIfUserCanVote();
    this.appConfig = appConfig;
    this.authenticationService.log.subscribe( value => {
      this.log = value;
    });
  }

  ngOnInit() {
    this.selectedNum = 1;
    this.options = Array.from(new Array(30), (_, index) => index + 1);
  }
  //
  // like(wine: Wine): Promise<void> {
  //   if (this.canVote) {
  //     wine.like();
  //     return this.wineService.updateWine(wine);
  //   }
  // }

  seeWineDetails(wine: Wine): void {
    if (wine.default) {
      this.router.navigate([AppConfig.routes.wines + '/' + wine.id]);
    }
  }

  addToCart(num: number) {
    // TODO: pass to the user's cart
    console.log(num);
  }

}
