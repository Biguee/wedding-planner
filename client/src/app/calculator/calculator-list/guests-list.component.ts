import {Component, Inject, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {FormControl, FormGroup} from "@angular/forms";
import {Subject} from "rxjs/Subject";
import {GuestsService} from "../guests.service";

@Component({
  selector: 'js-guests-list',
  templateUrl: './guests-list.component.html',
  styleUrls: ['./guests-list.component.css']
})
export class GuestsListComponent{

  selected = {};
  edited = null;
  guests = [];



  private guestSubject = new Subject();

  constructor(private guestService: GuestsService){
  }

  ngOnInit(): void {
    this.refresh();
  }

  select(guest){
    this.selected = guest;
    this.edited = Object.assign({}, guest);
    console.log(guest)
  }

  private refresh() {
    this.guestService.getAll()
      .subscribe(guests => this.guests = guests.guests)
  }

  save() {
    this.guestService.update(this.edited).subscribe(() => this.refresh())
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
    this.guestService.delete(this.edited)
      // .subscribe(()=>this.refresh())
    this.reset()
  }

}
