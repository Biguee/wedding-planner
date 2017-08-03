import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'js-calculator-card',
  templateUrl: './calculator-card.component.html',
  styleUrls: ['./calculator-card.component.css']
})
export class CalculatorCardComponent{

  @Input()
  calculator = {}

  @Input()
  isSelected = false

  @Output('selected')
  onSelect = new EventEmitter()

  select(){
    this.onSelect.emit(this.calculator)
  }


}
