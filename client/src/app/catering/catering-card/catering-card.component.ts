import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'js-catering-card',
  templateUrl: './catering-card.component.html',
  styleUrls: ['./catering-card.component.css']
})
export class CateringCardComponent{

  @Input()
  catering = {}

  @Input()
  isSelected = false

  @Output('selected')
  onSelect = new EventEmitter()

  select(){
    this.onSelect.emit(this.catering)
  }
}
