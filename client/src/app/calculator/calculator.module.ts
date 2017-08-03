import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CalculatorListComponent } from './calculator-list/calculator-list.component';
import { CalculatorFormComponent } from './calculator-form/calculator-form.component';
import { CalculatorCardComponent } from './calculator-card/calculator-card.component';
import { AddCalculatorComponent } from './add-calculator/add-calculator.component';
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {CalculatorService} from "./calculator.service";

@NgModule({
  imports: [
    CommonModule,
    HttpModule,
    FormsModule,
    RouterModule,
  ],
  declarations: [CalculatorListComponent, CalculatorFormComponent, CalculatorCardComponent, AddCalculatorComponent],
  exports: [
    CalculatorListComponent,
    CalculatorFormComponent
  ],
  providers: [
    CalculatorService,
  ]
})
export class CalculatorModule { }
