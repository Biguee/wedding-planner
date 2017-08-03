import { Component, OnInit } from '@angular/core';
import {GamesService} from "../games.service";
import {Subject} from "rxjs/Subject";

@Component({
  selector: 'js-games-list',
  templateUrl: './games-list.component.html',
  styleUrls: ['./games-list.component.css']
})
export class GamesListComponent implements OnInit {

  selected = {};
  edited = null;
  games = [];

  private gameSubject = new Subject();

  constructor(private gamesService: GamesService){
  }

  ngOnInit(): void {
    this.refresh();
  }

  select(game){
    this.selected = game;
    this.edited = Object.assign({}, game);
    console.log(game)
  }

  private refresh() {
    this.gamesService.getAll()
      .subscribe(games => this.games = games.games)
  }

  save() {
    this.gamesService.update(this.edited).subscribe(() => this.refresh())
    this.reset()
  }
  reset() {
    this.selected = {}
    this.edited = null
  }

  cancel() {
    this.reset()
  }

  delete(){
    this.gamesService.delete(this.edited)
    this.reset()
  }


}
