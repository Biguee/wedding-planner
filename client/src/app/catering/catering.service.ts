import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Api} from "../api";
import {Observable} from "rxjs/Observable";
import {Catering} from "./catering";

@Injectable()
export class CateringService {


  constructor(private http: Http, private api: Api){
  }

  getAll(): Observable<any> {
    return this.http.get(this.api.cateringUrl)
      .map(response => response.json())
      .do(games => console.log(games))
  }


  update(catering: Catering): Observable<any> {
    return this.http.put(`${this.api.cateringUrl}/${catering.id}`, catering)
      .map(response => response.json())
  }

  delete(id: number){
    console.log(id)
    return this.http.delete(`${this.api.cateringUrl}/${id}`)
      .map(response => response.json())
  }

  addNewCatering(catering: Catering): Observable<any>{
    return this.http.post(this.api.cateringUrl, catering)
  }


}
