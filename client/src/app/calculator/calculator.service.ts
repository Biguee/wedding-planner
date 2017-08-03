import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Api} from "../api";
import {Observable} from "rxjs/Observable";
import {Calculator} from "./calculator";


@Injectable()
export class CalculatorService {

  constructor(private http: Http, private api: Api){
  }

  getAll(): Observable<any> {
    return this.http.get(this.api.calculatorUrl)
      .map(response => response.json())
      .do(games => console.log(games))
  }


  update(calculator: Calculator): Observable<any> {
    return this.http.put(`${this.api.calculatorUrl}/${calculator.id}`, calculator)
      .map(response => response.json())
  }

  delete(id: number){
    console.log(id)
    return this.http.delete(`${this.api.calculatorUrl}/${id}`)
      .map(response => response.json())
  }

  addNewCalculator(calculator: Calculator): Observable<any>{
    return this.http.post(this.api.calculatorUrl, calculator)
  }



}
