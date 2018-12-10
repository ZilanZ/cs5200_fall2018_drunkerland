import {Component, OnInit} from '@angular/core';
import {Wine} from '../../shared/wine.model';
import {WineService} from '../../shared/wine.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Location} from '@angular/common';
import {AppConfig} from '../../../../configs/app.config';
import {UtilsHelperService} from '../../../../core/services/utils-helper.service';

@Component({
  selector: 'app-wine-detail-page',
  templateUrl: './wine-detail-page.component.html',
  styleUrls: ['./wine-detail-page.component.scss'],
  animations: [UtilsHelperService.fadeInOut()]
})

export class WineDetailPageComponent implements OnInit {

  wine: Wine;
  canVote: boolean;

  constructor(private wineService: WineService,
              private location: Location,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    const wineId = this.activatedRoute.snapshot.paramMap.get('id');
    this.wineService.getWine(wineId).subscribe((wine: Wine) => {
      this.wine = wine;
    });
  }

  dynamicImport() {
    import('html2canvas').then((html2canvas: any) => {
      html2canvas.default(document.getElementById('winee-detail')).then((canvas) => {
        window.open().document.write('<img src="' + canvas.toDataURL() + '" />');
      });
    });
  }

  goBack(): void {
    this.location.back();
  }

  goToTheAnchor(): void {
    this.router.navigate([`/${AppConfig.routes.wines}/${this.wine.id}`], {fragment: 'winee-detail'});
  }
}
