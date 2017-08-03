import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CateringService} from "../../catering/catering.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Catering} from "../catering";

@Component({
  selector: 'js-catering-form',
  templateUrl: './catering-form.component.html',
  styleUrls: ['./catering-form.component.css']
})
export class CateringFormComponent implements OnInit {

  // cateringService: any;

  @Input()
  catering

  @Output('cancel')
  onCancel = new EventEmitter()

  editable = true

  caterings = []

  constructor(private cateringService: CateringService, private route: ActivatedRoute, private router: Router){
  }

  ngOnInit(): void {
    if (!this.catering) {
      let catering = this.route.snapshot.data.catering
      this.editable = false
      this.catering = catering || {}
    }
  }

  delete(){
    this.cateringService.delete(this.catering.id)
      .subscribe(() => this.navigateHome())
  }

  update(){
    this.cateringService.update(this.catering)
      .subscribe(() => this.router.navigateByUrl("/catering-list"))
  }


  navigateHome() {
    this.router.navigate(['/home'])
  }



}
