import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { WineServiceClient } from '../../../../services/wine.service.client';
import { Wine } from '../../../modules/wines/shared/wine.model';

@Component({
  selector: 'app-main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.scss']
})

export class MainNavComponent implements OnInit {
  key: string;
  inputValue: string;
  @Output() searchWines: EventEmitter<Wine[]> = new EventEmitter();

  conditions = [
    { name: 'Name' },
    { name: 'Vintage' },
    { name: 'Color' },
    { name: 'Region' },
    { name: 'Appellation' },
    { name: 'Country' }
  ];

  constructor(
    private searchService: WineServiceClient
  ) { }

  ngOnInit() {
    this.key = '';
    this.inputValue = '';
  }

  // onKey(event: KeyboardEvent) {
  //   this.inputValue = (<HTMLInputElement>event.target).inputValue;
  // }

  search(key: string) {
    if (this.inputValue !== '') {
      this.searchWines.emit(null);

      switch (key) {
        case 'Name': {
          if (this.inputValue !== '') {
            this.searchService.getWinesByName(this.inputValue)
              .then(response => this.searchWines.emit(response));
          }
          break;
        }
        case 'Vintage': {
          if (this.inputValue !== '') {
            this.searchService.getWinesByVintage(this.inputValue)
              .then(response => this.searchWines.emit(response));
          }
          break;
        }
        case 'Color': {
          if (this.inputValue !== '') {
            this.searchService.getWinesByColor(this.inputValue)
              .then(response => this.searchWines.emit(response));
          }
          break;
        }
        case 'Region': {
          if (this.inputValue !== '') {
            this.searchService.getWinesByRegion(this.inputValue)
              .then(response => this.searchWines.emit(response));
          }
          break;
        }
        case 'Appellation': {
          if (this.inputValue !== '') {
            this.searchService.getWinesByAppellation(this.inputValue)
              .then(response => this.searchWines.emit(response));
          }
          break;
        }
        case 'Country': {
          if (this.inputValue !== '') {
            this.searchService.getWinesByCountry(this.inputValue)
              .then(response => this.searchWines.emit(response));
          }
          break;
        }
        default: {
          this.searchWines.emit([]);
          break;
        }
      }
    }
  }

}
