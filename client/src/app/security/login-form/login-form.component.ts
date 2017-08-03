import {Component, OnInit} from '@angular/core';
import { SecurityService } from '../security.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit{

  username: string
  password: string
  loginError: boolean
  pendingRequest = false

  constructor(private securityService: SecurityService, private router: Router) {
  }

  loginFormMethod() {
    this.pendingRequest = true
    this.securityService.login(this.username, this.password)
      .subscribe(() => {
        console.log(this.securityService.isAuthenticated());
        this.router.navigateByUrl('/')
      }, () => {
        this.loginError = true
        this.pendingRequest = false
      })
  }

  ngOnInit() {
  }

  navigateHome() {
    this.router.navigate(['/'])
  }


}
