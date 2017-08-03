import { Component, OnInit } from '@angular/core';
import {Subject} from "rxjs/Subject";
import {CalculatorService} from "../calculator.service";
import {forEach} from "@angular/router/src/utils/collection";

@Component({
  selector: 'js-calculator-list',
  templateUrl: './calculator-list.component.html',
  styleUrls: ['./calculator-list.component.css']
})
export class CalculatorListComponent implements OnInit {

  selected = {};
  edited = null;
  calculator = [];
  guests = [];

  sum = 0;

  calculateCost() {
    console.log(this.calculator.length)
  }

  calculateGuests() {
    console.log(this.guests.length)
  }


  private guestSubject = new Subject();

  private calculatorSubject = new Subject();

  constructor(private calculatorService: CalculatorService){
  }

  ngOnInit(): void {
    this.refresh();
  }

  select(calculator){
    this.selected = calculator;
    this.edited = Object.assign({}, calculator);
    console.log(calculator)
  }

  private refresh() {
    this.calculatorService.getAll()
      .subscribe(calculator => this.calculator = calculator.calculator)
  }

  save() {
    this.calculatorService.update(this.edited).subscribe(() => this.refresh())
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
    this.calculatorService.delete(this.edited)
    this.reset()
  }


}
