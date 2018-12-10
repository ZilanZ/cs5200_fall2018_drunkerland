import {Component, OnInit, ViewChild} from '@angular/core';
import {Wine} from '../../shared/wine.model';
import {WineService} from '../../shared/wine.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {MatDialog, MatSnackBar} from '@angular/material';
import {Router} from '@angular/router';
import {AppConfig} from '../../../../configs/app.config';
import {_} from '@biesbjerg/ngx-translate-extract/dist/utils/utils';
import {TranslateService} from '@ngx-translate/core';
import {UtilsHelperService} from '../../../../core/services/utils-helper.service';
import {WineRemoveComponent} from '../../components/wine-remove/wine-remove.component';

@Component({
  selector: 'app-wines-list-page',
  templateUrl: './wines-list-page.component.html',
  styleUrls: ['./wines-list-page.component.scss'],
  animations: [UtilsHelperService.fadeInOut()]
})

export class WinesListPageComponent implements OnInit {

  wines: Wine[];
  newWineForm: FormGroup;
  canVote = false;
  error: string;
  @ViewChild('form') myNgForm; // just to call resetForm method

  constructor(private wineService: WineService,
              private dialog: MatDialog,
              private snackBar: MatSnackBar,
              private translateService: TranslateService,
              private router: Router,
              private formBuilder: FormBuilder) {
    this.canVote = WineService.checkIfUserCanVote();

    this.newWineForm = this.formBuilder.group({
      'name': new FormControl('', [Validators.required]),
      'alterEgo': new FormControl('', [Validators.required])
    });

    this.onChanges();
  }

  ngOnInit() {
    this.wineService.getWines().subscribe((wines: Array<Wine>) => {
      this.wines = wines;
    });
  }

  createNewWine(newWine: any) {
    if (this.newWineForm.valid) {
      this.wineService.createWine(new Wine(newWine)).then(() => {
        this.myNgForm.resetForm();
      }, () => {
        this.error = 'errorHasOcurred';
      });
    }
  }

  like(wine: Wine) {
    this.canVote = WineService.checkIfUserCanVote();
    if (this.canVote) {
      wine.like();
      this.wineService.updateWine(wine);
    }
  }

  deleteWine(wine: Wine) {
    const dialogRef = this.dialog.open(WineRemoveComponent);
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.wineService.deleteWine(wine.id).then(() => {
          this.wineService.showSnackBar('wineRemoved');
        }, () => {
          this.error = 'wineDefault';
        });
      }
    });
  }

  seeWineDetails(wine): void {
    if (wine.default) {
      this.router.navigate([AppConfig.routes.wines + '/' + wine.id]);
    }
  }

  private onChanges() {
    this.newWineForm.get('name').valueChanges.subscribe((value) => {
      if (value && value.length >= 3 && UtilsHelperService.isPalindrome(value)) {
        this.snackBar.open(this.translateService.instant(String(_('yeahPalindrome'))));
      } else {
        this.snackBar.dismiss();
      }
    });
  }
}
