import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GamesListComponent } from './games-list/games-list.component';
import { GamesFormComponent } from './games-form/games-form.component';
import { GamesCardComponent } from './games-card/games-card.component';
import { AddGameComponent } from './add-game/add-game.component';
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {GamesService} from "./games.service";

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    FormsModule,
    RouterModule
  ],
  declarations: [GamesListComponent, GamesFormComponent, GamesCardComponent, AddGameComponent],
  exports: [
    GamesListComponent,
    GamesFormComponent
  ],
  providers: [
    GamesService
  ]
})
export class GamesModule { }
