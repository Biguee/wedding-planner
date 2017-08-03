import { Route, RouterModule} from '@angular/router';
import { LoginFormComponent } from './security/login-form/login-form.component'
import { SecurityGuard } from './security/security.guard';
import { UsersListComponent } from './users/users-list/users-list.component';
import {GuestsListComponent} from "./guests/guests-list/guests-list.component";

const routesConfig: [Route] = [
  {
    path: 'users',  component: UsersListComponent, canActivate: [SecurityGuard]
  }

]

export const routerModule = RouterModule.forChild(routesConfig)
