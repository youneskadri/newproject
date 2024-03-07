import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OffreFournisseur } from 'app/Module/OffreFournisseur';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OffreFournisseurService {
  private apiUrl = 'http://localhost:8082/OffreFournisseur'
  private api = 'http://localhost:8082'; // Base URL for the API

  constructor(private http: HttpClient) { }

  addOffre(id): Observable<OffreFournisseur> {
    return this.http.post<OffreFournisseur>(`${this.apiUrl}/add/${id}`, OffreFournisseur);
  }

  getAllOffre(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/getAll`);
  }

  deleteoffre(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }

  updateOffre(id,statut): Observable<OffreFournisseur> {
    console.log(id,statut)
    return this.http.post<OffreFournisseur>(`${this.apiUrl}/update`,{id,statut:"Accepte"});
  }
generatePdf(id){
  return this.http.get<any>(`${this.api}/item-report/${id}`);


}
add(donnes,id){
  return this.http.post<any>(`${this.apiUrl}/add/${id}`,donnes);

}

}
