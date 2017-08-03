import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CateringListComponent } from './catering-list/catering-list.component';
import { CateringFormComponent } from './catering-form/catering-form.component';
import { CateringCardComponent } from './catering-card/catering-card.component';
import { AddCateringComponent } from './add-catering/add-catering.component';
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {CateringService} from "./catering.service";

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    FormsModule,
    RouterModule
  ],
  declarations: [CateringListComponent, CateringFormComponent, CateringCardComponent, AddCateringComponent],
  exports: [
    CateringListComponent,
    CateringFormComponent
  ],
  providers: [
    CateringService
  ]
})
export class CateringModule { }
