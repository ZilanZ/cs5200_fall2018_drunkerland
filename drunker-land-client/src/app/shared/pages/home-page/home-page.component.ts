import {Component, OnInit} from '@angular/core';
import {Wine} from '../../../modules/wines/shared/wine.model';
import {WineService} from '../../../modules/wines/shared/wine.service';
import {AppConfig} from '../../../configs/app.config';
import {UtilsHelperService} from '../../../core/services/utils-helper.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
  animations: [UtilsHelperService.fadeInOut()]
})

export class HomePageComponent implements OnInit {
  wines: Wine[] = null;

  constructor(private wineService: WineService) {
  }

  ngOnInit() {
    this.wineService.getWines().subscribe((wines: Array<Wine>) => {
      this.wines = wines.slice(0, AppConfig.topWinesLimit);
    });
  }

  onSearch(searchWines: Wine[]) {
    this.wines = searchWines;
  }
}
