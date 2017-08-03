import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {GamesService} from "../games.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'js-games-form',
  templateUrl: './games-form.component.html',
  styleUrls: ['./games-form.component.css']
})
export class GamesFormComponent implements OnInit {

  guestService: any;

  @Input()
  game

  @Output('cancel')
  onCancel = new EventEmitter()

  editable = true

  games = []

  constructor(private gamesService: GamesService, private route: ActivatedRoute, private router: Router){
  }

  ngOnInit(): void {
    if (!this.game) {
      let game = this.route.snapshot.data.game
      this.editable = false
      this.game = game || {}
    }
  }

  delete(){
    this.gamesService.delete(this.game.id)
      .subscribe(() => this.navigateHome())
  }

  update(){
    this.gamesService.update(this.game)
      .subscribe(() => this.router.navigateByUrl("/games-list"))
  }


  navigateHome() {
    this.router.navigate(['/home'])
  }



}
