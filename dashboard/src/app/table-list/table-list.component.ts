import { Component, OnInit } from '@angular/core';
import {EventService} from "../Service/event.service";

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css']
})
export class TableListComponent implements OnInit {

  constructor(private _eventService:EventService) { }
  events:any [] ;
  reservations:number;
  ngOnInit() {
    this._eventService.getall().subscribe((result)=>{
      this.events=result;
      console.log(this.events)

    },error => {
      console.log(error)
    })
  }


}
