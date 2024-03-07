import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Produit } from 'app/Module/Produit';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  private apiUrl = 'http://localhost:8082/Produit'; // Base URL for the API

  constructor(private http: HttpClient) { }

  addProduit(produit: Produit): Observable<Produit> {
    return this.http.post<Produit>(`${this.apiUrl}/add`, produit);
  }
  getProduitParEvent(id:number): Observable<Produit[]> {
    return this.http.get<Produit[]>(`${this.apiUrl}/Evenement/${id}`);
  }

  getAllProduit(): Observable<Produit[]> {
    return this.http.get<Produit[]>(`${this.apiUrl}/getAll`);
  }

  deleteProduit(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }

  updateProduit(produit: Produit): Observable<Produit> {
    return this.http.put<Produit>(`${this.apiUrl}/update`, produit);
  }
}
