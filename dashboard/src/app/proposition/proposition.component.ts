import { Component, OnInit } from '@angular/core';
import { Proposition } from 'app/Module/proposition';
import { PropositionService } from 'app/Service/serviceproposition/proposition.service';
import { EventService } from 'app/Service/ServiceEvenement/event-service.service';
import { evenement } from 'app/Module/evenement';
import {Produit} from "../Module/Produit";
import {ProduitService} from "../Service/serviceProduit/produit.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-proposition',
  templateUrl: './proposition.component.html',
  styleUrls: ['./proposition.component.scss']
})
export class PropositionComponent implements OnInit {
  constructor(private _eventService:EventService,private router:Router,private propositionService:PropositionService) { }
  proposations:any[] ;
  reservations:number;
  ngOnInit() {
    this.propositionService.getAll().subscribe((result)=>{
      this.proposations=result;
      console.log(result)
    },error => {
      console.log(error)
    })
  }
  onclick(idProp,idEvent){
    this.router.navigate([`/offre/${idProp}/${idEvent}`]);

  }
}
