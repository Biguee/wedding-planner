import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GuestsListComponent } from './guests-list/guests-list.component';
import {HttpModule} from "@angular/http";
import { GuestFormComponent } from './guest-form/guest-form.component';
import { GuestCardComponent } from './guest-card/guest-card.component';
import {GuestsService} from "./guests.service";
import {FormsModule} from "@angular/forms";
import { GuestsPanelComponent } from './guests-panel/guests-panel.component';
import { AddGuestComponent } from './add-guest/add-guest.component';
import {RouterModule} from "@angular/router";

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    FormsModule,
    RouterModule
  ],
  declarations: [
    GuestsListComponent,
    GuestFormComponent,
    GuestCardComponent,
    GuestsPanelComponent,
    AddGuestComponent,
  ],
  exports: [
    GuestsListComponent,
    GuestFormComponent
  ],
  providers: [
    GuestsService
  ]
})
export class GuestsModule { }
