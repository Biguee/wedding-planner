import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {GuestsService} from "../guests.service";


@Component({
  selector: 'js-guest-form',
  templateUrl: './guest-form.component.html',
  styleUrls: ['./guest-form.component.css']
})
export class GuestFormComponent implements OnInit {


  guestService: any;

  @Input()
  guest

  @Output('cancel')
  onCancel = new EventEmitter()

  editable = true

  guests = []

  constructor(private guestsService: GuestsService, private route: ActivatedRoute, private router: Router){
  }

  ngOnInit(): void {
    if (!this.guest) {
      let guest = this.route.snapshot.data.guest
      this.editable = false
      this.guest = guest || {}
    }
  }

  delete(){
    this.guestsService.delete(this.guest.id)
      .subscribe(() => this.navigateHome())
  }

  update(){
    this.guestsService.update(this.guest)
      .subscribe(() => this.router.navigateByUrl("/users-list"))
  }


  navigateHome() {
    this.router.navigate(['/home'])
  }





}
