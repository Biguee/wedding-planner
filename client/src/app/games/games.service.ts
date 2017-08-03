import { Injectable } from '@angular/core';
import {Http} from "@angular/http";
import {Api} from "../api";
import {Observable} from "rxjs/Observable";
import {Games} from "./games";

@Injectable()
export class GamesService {

  constructor(private http: Http, private api: Api){
  }

  getAll(): Observable<any> {
    return this.http.get(this.api.gamesUrl)
      .map(response => response.json())
      .do(games => console.log(games))
  }


  update(games: Games): Observable<any> {
    return this.http.put(`${this.api.gamesUrl}/${games.id}`, games)
      .map(response => response.json())
  }

  delete(id: number){
    console.log(id)
    return this.http.delete(`${this.api.gamesUrl}/${id}`)
      .map(response => response.json())
  }

  addNewGame(games: Games): Observable<any>{
    return this.http.post(this.api.gamesUrl, games)
  }


}
