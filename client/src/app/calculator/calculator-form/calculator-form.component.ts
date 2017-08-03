import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CalculatorService} from "../calculator.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'js-calculator-form',
  templateUrl: './calculator-form.component.html',
  styleUrls: ['./calculator-form.component.css']
})
export class CalculatorFormComponent implements OnInit {

  // guestService: any;

  @Input()
  calculator

  @Output('cancel')
  onCancel = new EventEmitter()

  editable = true

  calculators = []

  constructor(private calculatorService: CalculatorService, private route: ActivatedRoute, private router: Router){
  }

  ngOnInit(): void {
    if (!this.calculator) {
      let calculator = this.route.snapshot.data.calculator
      this.editable = false
      this.calculator = calculator || {}
    }
  }

  delete(){
    this.calculatorService.delete(this.calculator.id)
      .subscribe(() => this.navigateHome())
  }

  update(){
    this.calculatorService.update(this.calculator)
      .subscribe(() => this.router.navigateByUrl("/calculator-list"))
  }


  navigateHome() {
    this.router.navigate(['/home'])
  }



}
