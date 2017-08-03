import { Component, OnInit } from '@angular/core';
import {GamesService} from "../games.service";
import {Router} from "@angular/router";

@Component({
  selector: 'js-add-game',
  templateUrl: './add-game.component.html',
  styleUrls: ['./add-game.component.css']
})
export class AddGameComponent implements OnInit {

  private game = {
    id: 0,
    name: '',
    description: ''

  };

  private registerResult: boolean;


  constructor(private gameService: GamesService, private router: Router) {
  }

  addGame() {
    this.gameService.addNewGame(this.game)
      .subscribe(() => this.router.navigateByUrl("/games-list"))
  };

  ngOnInit() {
  }

}
