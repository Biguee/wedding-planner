import {Route, RouterModule} from '@angular/router';
import {LoginFormComponent} from './security/login-form/login-form.component'
import {SecurityGuard} from './security/security.guard';
import {UsersListComponent} from './users/users-list/users-list.component';
import {GuestsListComponent} from "./guests/guests-list/guests-list.component";
import {HomeCardComponent} from "./home/home-card/home-card.component";
import {RegisterFormComponent} from "./security/register-form/register-form.component";
import {LogoutFormComponent} from "./security/logout-form/logout-form.component";
import {AddGuestComponent} from "./guests/add-guest/add-guest.component";
import {GamesListComponent} from "./games/games-list/games-list.component";
import {CateringListComponent} from "./catering/catering-list/catering-list.component";
import {CalculatorListComponent} from "./calculator/calculator-list/calculator-list.component";
import {AddGameComponent} from "./games/add-game/add-game.component";
import {AddCateringComponent} from "./catering/add-catering/add-catering.component";
import {AddCalculatorComponent} from "./calculator/add-calculator/add-calculator.component";

const routesConfig: [Route] = [

  {
    path: 'login', component: LoginFormComponent
  },
  {
    path: 'logout', component: LogoutFormComponent
  },
  {
    path: 'register', component: RegisterFormComponent
  },
  {
    path: 'guests-list', component: GuestsListComponent
  },
  {
    path: 'games-list', component: GamesListComponent
  },
  {
    path: 'catering-list', component: CateringListComponent
  },
  {
    path: 'calculator-list', component: CalculatorListComponent
  },
  {
    path: 'home', component: HomeCardComponent
  },
  {
    path: 'addGuest', component: AddGuestComponent
  },
  {
    path: 'addGame', component: AddGameComponent
  },
  {
    path: 'addCatering', component: AddCateringComponent
  },
  {
    path: 'addCalculator', component: AddCalculatorComponent
  },
  {
    path: '**', component: HomeCardComponent
  },
  {
    path: '', canActivate: [SecurityGuard], children: [
    {
      path: 'users', component: UsersListComponent
    }
  ]
  }
]

export const routerModule = RouterModule.forRoot(routesConfig)
