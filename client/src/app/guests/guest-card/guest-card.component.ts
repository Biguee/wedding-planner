import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';


@Component({
  selector: 'js-guest-card',
  templateUrl: './guest-card.component.html',
  styleUrls: ['./guest-card.component.css']
})
export class GuestCardComponent{

  @Input()
  guest = {}

  @Input()
  isSelected = false

  @Output('selected')
  onSelect = new EventEmitter()

  select(){
    this.onSelect.emit(this.guest)
  }

}
