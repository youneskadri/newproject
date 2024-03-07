import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Produit } from 'app/Module/Produit';
import { ProduitService } from 'app/Service/serviceProduit/produit.service';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.scss']
})
export class ProduitComponent implements OnInit {
  produits: Produit[] = [];
  newProduit: Produit = new Produit();
  updateMode = false;
  updateId: number | null = null; 
  produitForm: FormGroup;

  constructor(private produitService: ProduitService) { }

  ngOnInit(): void {
    this.loadProduits();

    this.produitForm = new FormGroup({
      nom: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      prix: new FormControl('', [Validators.required]),
    });
  }

  loadProduits(): void {
    this.produitService.getAllProduit().subscribe(data => {
      this.produits = data;
    });
  }

  addProduit(): void {
    if (this.produitForm.valid && !this.updateMode) {
      this.newProduit = this.produitForm.value;
      this.produitService.addProduit(this.newProduit).subscribe(() => {
        this.loadProduits();
        this.newProduit = new Produit();
        this.produitForm.reset();
      });
    } else {
      this.produitForm.markAllAsTouched();
    }
  }

  deleteProduit(id: number): void {
    this.produitService.deleteProduit(id).subscribe(() => {
      this.loadProduits();
    });
  }

  updateProduit(produit: Produit): void {
    this.newProduit = { ...produit };
    this.updateMode = true;
    this.produitForm.patchValue({
      nom: produit.nom,
      description: produit.description,
      prix: produit.prix
    });
    this.updateId = produit.id;
  }

  saveUpdate(): void {
    if (this.produitForm.valid && this.updateMode && this.updateId !== null) {
      this.produitService.updateProduit(this.newProduit).subscribe(() => {
        console.log('Product updated successfully.');
        this.updateMode = false;
        this.updateId = null;
        this.newProduit = new Produit();
        this.loadProduits();
        this.produitForm.reset();
      }, error => {
        console.error('Error updating product:', error);
      });
    } else {
      console.warn('Form is invalid or not in update mode. Cannot save update.');
    }
  }
  
  
}
