import { Component, OnInit } from '@angular/core';
import { PropositionService } from 'app/Service/serviceproposition/proposition.service';
import { EventService } from 'app/Service/ServiceEvenement/event-service.service';
import { evenement } from 'app/Module/evenement';
import {Produit} from "../Module/Produit";
import {ProduitService} from "../Service/serviceProduit/produit.service";
import {ActivatedRoute, Route, Routes} from "@angular/router";
import {OffreFournisseurService} from "../Service/serviceOffreFournisseur/offre-fournisseur.service";

@Component({
  selector: 'app-offre',
  templateUrl: './offre.component.html',
  styleUrls: ['./offre.component.scss']
})
export class OffreComponent implements OnInit {
  offre: any[] = [];
  events: evenement[] = [];
  message;
  nom;
  offreService
  formData: FormData = new FormData();
  produit = new Produit();
  disabledProduit: boolean;
  price:any[];
  prix: { [key: number]: number } = {};
  quantite: { [key: number]: number } = {};
  idProposition;
  idEvent;
  updateMode = false;
  updateId: number | null = null;
  selectedEvent;
  nameFournisseur;
  products:any[]
  selectedValueEvent
  selectedValueProduct

  constructor(
      private propositionService: PropositionService,
      private evenementService: EventService,
      private produitService:ProduitService,
      private route:ActivatedRoute,
      private offreServic:OffreFournisseurService
  ) { }

  ngOnInit(): void {

    this.route.params.subscribe(params => {
      this.idProposition = params['id1'];
      this.idEvent = params['id2'];
    });
    this.produitService.getProduitParEvent(this.idEvent).subscribe(
        (result)=> {
          this.products = result

        },(error)=>{
          console.log(error)

        }

    )
  }



  addOffre(): void {
    console.log(this.products)


    console.log(this.prix);
    let donnees = [];
    this.products.forEach(produit => {
      let produitId = produit.id;
      let prixProduit = this.prix[produitId];
      let quantiteProduit = this.quantite[produitId];
      donnees.push({ produitId: produitId, prix: prixProduit, quantite: quantiteProduit ,propositionId:this.idProposition,nameFournisseur:this.nameFournisseur});
    });
    this.offreServic.add(donnees,this.idProposition).subscribe(
        (result)=>{
          console.log(result)
        },
        (error)=>{
          console.log(error)
        }
    )
  }
}
