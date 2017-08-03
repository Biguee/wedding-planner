import { Component, OnInit } from '@angular/core';
import {CalculatorService} from "../calculator.service";
import {Router} from "@angular/router";

@Component({
  selector: 'js-add-calculator',
  templateUrl: './add-calculator.component.html',
  styleUrls: ['./add-calculator.component.css']
})
export class AddCalculatorComponent implements OnInit {

  private calculator = {
    id: 0,
    name: '',
    cost: null

  };

  private registerResult: boolean;


  constructor(private calculatorService: CalculatorService, private router: Router) {
  }

  addCalculator() {
    this.calculatorService.addNewCalculator(this.calculator)
      .subscribe(() => this.router.navigateByUrl("/calculator-list"))
  };

  ngOnInit() {
  }
}
