import {map, startWith} from 'rxjs/operators';
import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Router} from '@angular/router';
import {Wine} from '../../../modules/wines/shared/wine.model';
import {WineService} from '../../../modules/wines/shared/wine.service';
import {LoggerService} from '../../../core/services/logger.service';
import {AppConfig} from '../../../configs/app.config';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  providers: [
    LoggerService
  ]
})

export class SearchBarComponent implements OnInit {

  defaultWines: Array<Wine>;
  wineFormControl: FormControl;
  filteredWines: any;

  constructor(private wineService: WineService,
              private router: Router) {
    this.defaultWines = [];
    this.wineFormControl = new FormControl();
  }

  ngOnInit() {
    this.wineService.getWines().subscribe((wines: Array<Wine>) => {
      this.defaultWines = wines.filter(wine => wine['default']);

      this.wineFormControl.valueChanges.pipe(
        startWith(null),
        map(value => this.filterWines(value)))
        .subscribe(wineesFiltered => {
          this.filteredWines = wineesFiltered;
        });
    });
  }

  filterWines(val: string): Wine[] {
    return val ? this.defaultWines.filter(wine => wine.name.toLowerCase().indexOf(val.toLowerCase()) === 0 && wine['default'])
      : this.defaultWines;
  }

  searchWine(wine: Wine): Promise<boolean> {
    LoggerService.log('Moved to wine with id: ' + wine.id);
    return this.router.navigate([AppConfig.routes.wines + '/' + wine.id]);
  }
}
