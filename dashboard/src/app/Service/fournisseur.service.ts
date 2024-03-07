import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fournisseur } from 'app/Module/Fournisseur';

@Injectable({
  providedIn: 'root'
})
export class FournisseurService {
  private apiUrl = 'http://localhost:8082/Fournisseur'; // Base URL for the API

  constructor(private http: HttpClient) { }

  addFournisseur(fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.http.post<Fournisseur>(`${this.apiUrl}/add`, fournisseur);
  }

  getAllFournisseurs(): Observable<Fournisseur[]> {
    return this.http.get<Fournisseur[]>(`${this.apiUrl}/getAll`);
  }

  deleteFournisseur(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }

  updateFournisseur(fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.http.put<Fournisseur>(`${this.apiUrl}/update`, fournisseur);
  }
}
