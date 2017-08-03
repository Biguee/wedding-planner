import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UsersModule } from "./users/users.module";
import { SecurityService } from "./security/security.service";
import  { Api } from './api';
import {SecurityModule} from "./security/security.module";
import {routerModule} from "./app.routing";
import {SecurityGuard} from "./security/security.guard";
import {GuestsModule} from "./guests/guests.module";
import {HomeModule} from "./home/home.module";
import {UsersService} from "./users/users.service";
import {GamesModule} from "./games/games.module";
import {CateringModule} from "./catering/catering.module";
import {CalculatorModule} from "./calculator/calculator.module";
import {GuestsService} from "./guests/guests.service";
import {CateringService} from "./catering/catering.service";
import {CalculatorService} from "./calculator/calculator.service";
import {GamesService} from "./games/games.service";



@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    UsersModule,
    GamesModule,
    CateringModule,
    CalculatorModule,
    SecurityModule,
    GuestsModule,
    routerModule,
    HomeModule
  ],
  providers: [
    SecurityService,
    UsersService,
    GuestsService,
    CateringService,
    CalculatorService,
    GamesService,
    Api,
    SecurityGuard
  ],
  bootstrap: [
    AppComponent]
})
export class AppModule { }
