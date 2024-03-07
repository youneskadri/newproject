import { Component, OnInit } from '@angular/core';
import { OffreFournisseur } from 'app/Module/OffreFournisseur';
import { Proposition } from 'app/Module/proposition';
import { StatutOffre } from 'app/Module/StatutOffre';
import { OffreFournisseurService } from 'app/Service/serviceOffreFournisseur/offre-fournisseur.service';
import { PropositionService } from 'app/Service/serviceproposition/proposition.service';
import {Router, Routes} from "@angular/router";

@Component({
  selector: 'app-offre-fournisseur',
  templateUrl: './offre-fournisseur.component.html',
  styleUrls: ['./offre-fournisseur.component.css']
})
export class OffreFournisseurComponent implements OnInit {
  offres: any[] = [];
  nom;
  propositions: Proposition[] = [];
  newOffre: OffreFournisseur = new OffreFournisseur();
  selectedOffre: OffreFournisseur | null = null;
  statutOffreOptions: string[] = Object.values(StatutOffre);

  constructor(
    private offreService: OffreFournisseurService,
    private propositionService: PropositionService,private route:Router
  ) { }

  ngOnInit(): void {
   this.offreService.getAllOffre().subscribe(
       (result)=>{
this.offres=result;
         console.log(result)
       },
       (error)=>{
         console.log(error)
       }


   )
  }

  loadPropositions(): void {
    this.propositionService.getAllProposition().subscribe(data => {
      this.propositions = data;
    });
  }

  loadOffres(): void {
    this.offreService.getAllOffre().subscribe(data => {
      this.offres = data;
    });
  }

  addOffre(): void {
    // Assurez-vous que les valeurs de proposition et de statut sont sélectionnées
    if ( this.newOffre.prposition && this.newOffre.status) {
      this.offreService.addOffre(this.newOffre).subscribe(offre => {
        this.offres.push(offre);
        this.newOffre = new OffreFournisseur(); // Réinitialiser le formulaire
      });
    } else {
      console.error("Veuillez sélectionner une proposition et un statut pour l'offre.");
    }
  }



  deleteOffre(id: number): void {
    this.offreService.deleteoffre(id).subscribe(() => {
      this.offres = this.offres.filter(offre => offre.idOffre !== id);
    });
  }

  updateOffrePdf(Id,statut): void {
    this.offreService.updateOffre(Id,statut).subscribe(
        (result)=>{
          window.open(`http://localhost:8082/item-report/${Id}`,'_blank')
          this.newOffre=result;
          this.offreService.getAllOffre().subscribe(
              (result)=>{
                this.offres=result;
                console.log(result)
              },
              (error)=>{
                console.log(error)
              }


          )

        },
        (error)=>{
          console.log(error)
        }
    )

  }



    updateOffre(Id,statut): void {
        this.offreService.updateOffre(Id,statut).subscribe(
            (result)=>{
                this.newOffre=result;
                this.offreService.getAllOffre().subscribe(
                    (result)=>{
                        this.offres=result;
                        console.log(result)
                    },
                    (error)=>{
                        console.log(error)
                    }


                )

            },
                (error)=>{
                    console.log(error)
                }
    )

    }
}
