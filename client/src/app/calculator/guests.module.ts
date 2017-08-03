

import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {GuestsListComponent} from "./calculator-list/guests-list.component";
import {GuestFormComponent} from "../guests/guest-form/guest-form.component";
import {GuestCardComponent} from "./calculator-card/guest-card.component";
import {GuestsPanelComponent} from "../guests/guests-panel/guests-panel.component";
import {AddGuestComponent} from "../guests/add-guest/add-guest.component";
import {GuestsService} from "./guests.service";
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
