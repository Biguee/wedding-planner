import {Component, Input, OnInit} from '@angular/core';
import {GuestsService} from "../guests.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'js-add-guest',
  templateUrl: './add-guest.component.html',
  styleUrls: ['./add-guest.component.css']
})
export class AddGuestComponent implements OnInit {

  private guest = {
      id: 0,
      name: '',
      surname: ''

  };

  private registerResult: boolean;


  constructor(private guestService: GuestsService, private router: Router) {
  }

  addGuest() {
    this.guestService.addNewGuest(this.guest)
      .subscribe(() => this.router.navigateByUrl("/guests-list"))
  };

  ngOnInit() {
  }



}
