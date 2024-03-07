import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FrontOfficeRoutingModule } from './front-office-routing.module';
import { FrontofficeComponent } from './frontoffice/frontoffice.component';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    FrontofficeComponent
  ],
  imports: [
    CommonModule,
    FrontOfficeRoutingModule,
    FormsModule,
  ]
})
export class FrontOfficeModule { }
