import { Component, OnInit } from '@angular/core';
import {CateringService} from "../catering.service";
import {Router} from "@angular/router";

@Component({
  selector: 'js-add-catering',
  templateUrl: './add-catering.component.html',
  styleUrls: ['./add-catering.component.css']
})
export class AddCateringComponent implements OnInit {

  private catering = {
    id: 0,
    name: '',
    kind:  ''
    //   [
    //   {
    //     string
    //   }
    // ]

  };

  private registerResult: boolean;


  constructor(private cateringService: CateringService, private router: Router) {
  }

  addCatering() {
    this.cateringService.addNewCatering(this.catering)
      .subscribe(() => this.router.navigateByUrl("/catering-list"))
  };

  ngOnInit() {
  }

}
