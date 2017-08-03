import { Component, OnInit } from '@angular/core';
import {CalculatorService} from "../../calculator/calculator.service";
import {Subject} from "rxjs/Subject";
import {Catering} from "../catering";
import {CateringService} from "../catering.service";

@Component({
  selector: 'js-catering-list',
  templateUrl: './catering-list.component.html',
  styleUrls: ['./catering-list.component.css']
})
export class CateringListComponent implements OnInit {

  selected = {};
  edited = null;
  catering = [];

  private cateringSubject = new Subject();

  constructor(private cateringService: CateringService){
  }

  ngOnInit(): void {
    this.refresh();
  }

  select(catering){
    this.selected = catering;
    this.edited = Object.assign({}, catering);
    console.log(catering)
  }

  private refresh() {
    this.cateringService.getAll()
      .subscribe(catering => this.catering = catering.catering)
  }

  save() {
    this.cateringService.update(this.edited).subscribe(() => this.refresh())
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
    this.cateringService.delete(this.edited)
    this.reset()
  }


}
