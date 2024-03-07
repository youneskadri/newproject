import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Proposition } from 'app/Module/proposition';

@Injectable({
  providedIn: 'root'
})
export class PropositionService {
  private apiUrl = 'http://localhost:8082/Proposition'; // URL de base de l'API

  constructor(private http: HttpClient) { }

  addProposition(proposition): Observable<Proposition> {
    return this.http.post<Proposition>(`${this.apiUrl}/add`, proposition);
  }
  getAll():Observable<any[]>{
    return this.http.get<any []>(`${this.apiUrl}/getAll`)
  }

  getAllProposition(): Observable<Proposition[]> {
    return this.http.get<Proposition[]>(`${this.apiUrl}/getAll`);
  }

  deleteProposition(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }

  updateProposition(proposition: Proposition): Observable<Proposition> {
    return this.http.put<Proposition>(`${this.apiUrl}/update`, proposition);
  }
  assignEventToProposition(id: number, idEvement: number): Observable<Proposition> {
    return this.http.post<Proposition>(`${this.apiUrl}/assignEvent/${id}/${idEvement}`, {});
  }
}
