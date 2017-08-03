import {Inject, Injectable, Optional} from '@angular/core';
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";
import { Api } from '../api';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import {Guests} from "./guests";

@Injectable()
export class GuestsService {

  constructor(private http: Http, private api: Api){
  }

  getAll(): Observable<any> {
    return this.http.get(this.api.guestUrl)
      .map(response => response.json())
      .do(guests => console.log(guests))
  }


  update(guest: Guests): Observable<any> {
    return this.http.put(`${this.api.guestUrl}/${guest.id}`, guest)
      .map(response => response.json())
  }

  delete(id: number){
    console.log(id)
    return this.http.delete(`${this.api.guestUrl}/${id}`)
      .map(response => response.json())
  }

  addNewGuest(guest: Guests): Observable<any>{
    return this.http.post(this.api.guestUrl, guest)
  }



}
