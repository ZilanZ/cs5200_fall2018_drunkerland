import { Component, OnInit } from '@angular/core';
import { Wine } from '../../../modules/wines/shared/wine.model';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.sass']
})
export class LayoutComponent implements OnInit {

  constructor() { }

  result: Wine[] = null;
  ngOnInit() {
  }

  onSearch(wines: Wine[]) {
    this.result = wines;
  }
}
