import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginFormComponent } from './login-form/login-form.component';
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import { RegisterFormComponent } from './register-form/register-form.component';
import { LogoutFormComponent } from './logout-form/logout-form.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  exports: [
    LoginFormComponent,
    LogoutFormComponent,
    RegisterFormComponent
  ],
  declarations: [LoginFormComponent, RegisterFormComponent, LogoutFormComponent]
})
export class SecurityModule { }
