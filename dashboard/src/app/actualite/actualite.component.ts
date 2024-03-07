import { Component, OnInit } from '@angular/core';
import  {ActualiteService} from '../Service/actualiteService/actualite.service'
import {error} from "jquery";
import {log} from "util";
import {Router} from "@angular/router";
@Component({
  selector: 'app-actualite',
  templateUrl: './actualite.component.html',
  styleUrls: ['./actualite.component.scss']
})
export class ActualiteComponent implements OnInit {
  file:File
  formData: any = new FormData();
  actuality;
  actualites
ngOnInit() {
    this.actualteService.getall().subscribe(
        (result)=>{
            console.log(result)
            this.actualites=result
        },
        (error)=>{
            console.log(error)
}
    )
}

    constructor(private actualteService: ActualiteService,private router:Router) {
  }
  ngOn


  fileuploded(event: any) {
    this.file = event.target.files[0];
    console.log(this.file);
  }

  onSubmit() {
    this.formData.append("file", this.file);
    this.formData.append("actuality", this.actuality);
    console.log("jehjzeh")

     this.actualteService.addData(this.file).subscribe(
        (result)=>{
          console.log(result.url)
          this.actualteService.add(this.actuality,result.url).subscribe(
              (results)=>{
                console.log(results)
              }
          )

        },(error)=>{
          console.log(error)

    }
    );


  }
  update(id){
      this.router.navigate([`/update/${id}`]);
  }
  delete(id){
this.actualteService.delete(id).subscribe(

    (result)=>{
        this.actualteService.getall().subscribe(
            (result)=>{
                console.log(result)
                this.actualites=result
            },
            (error)=>{
                console.log(error)
            }
        )






    },(error)=>{
        console.log(error)
    }
)
  }
}
