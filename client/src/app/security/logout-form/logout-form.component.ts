import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Router} from "@angular/router";
import {UsersService} from "../../users/users.service";
import {SecurityService} from "../security.service";

@Component({
  selector: 'js-logout-form',
  templateUrl: './logout-form.component.html',
  styleUrls: ['./logout-form.component.css']
})
export class LogoutFormComponent implements OnInit {


  @Output('logout')
  onLogout = new EventEmitter();

  constructor(private securityService: SecurityService, private router: Router) {
  }

  logoutFormMethod() {
    this.securityService.logout()
    this.navigateHome()
  }

  ngOnInit() {
  }

  navigateHome() {
    this.router.navigate(['/home'])
  }

}
