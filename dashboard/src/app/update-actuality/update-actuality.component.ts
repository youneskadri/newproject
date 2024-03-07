import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ActualiteService} from "../Service/actualiteService/actualite.service";

@Component({
  selector: 'app-update-actuality',
  templateUrl: './update-actuality.component.html',
  styleUrls: ['./update-actuality.component.scss']
})
export class UpdateActualityComponent implements OnInit {
id;
  actuality
  constructor(private route :ActivatedRoute,private actualiteService:ActualiteService,private router:Router) { }
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      console.log(this.id)
    });

  }

  onSubmit(){
      console.log(this.id,this.actuality)
    this.actualiteService.update(this.id,this.actuality).subscribe(
        (result)=>{
          console.log(result)
          this.router.navigate([`/act`]);


        },
        (error)=>{
          console.log(error)
        }
    )

  }

}
