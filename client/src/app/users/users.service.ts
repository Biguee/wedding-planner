import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Api } from '../api';
import 'rxjs/add/operator/map';
import {User} from './user';

@Injectable()
export class UsersService {

  constructor(private http: Http, private api: Api ) {
  }

  // getAll(): Observable<[User]>{
  //   return this.http.get(this.api.users)
  //     .map(response => response.json())
  //     .map(page => page.users)
  //     .flatMap(users => users)
  //     .map(json => new User(json))
  //     .toArray()
  // }

  getActiveUser(): Observable<User> {
    return this.http.get(this.api.activeUser)
      .map(response => response.json())
      .map(json => new User(json))
  }

  addNewUser(user: any): Observable<any>{
    return this.http.post(this.api.userProfile, user);
  }

}
