import { Component, OnInit } from '@angular/core';
import {UsersService} from "../../users/users.service";
import {Router} from "@angular/router";

@Component({
  selector: 'js-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  private userProfile = {
    userProfileDto: {
      name: '',
      surname: ''
    },
    login: '',
    password: ''
  };

  private registerResult: boolean;


  constructor(private userService: UsersService, private router: Router) {
  }

  registerFormMethod() {
    this.userService.addNewUser(this.userProfile)
      .subscribe(() => {
        this.router.navigateByUrl("/login")
      }, () => {
        console.log('failed')
        this.registerResult = false;
      })
  };

  ngOnInit() {
  }


}
