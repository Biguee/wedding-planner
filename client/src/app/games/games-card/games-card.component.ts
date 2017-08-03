import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'js-games-card',
  templateUrl: './games-card.component.html',
  styleUrls: ['./games-card.component.css']
})
export class GamesCardComponent{

  @Input()
  game = {}

  @Input()
  isSelected = false

  @Output('selected')
  onSelect = new EventEmitter()

  select(){
    this.onSelect.emit(this.game)
  }
}
