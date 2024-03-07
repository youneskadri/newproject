// event.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { evenement } from 'app/Module/evenement';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  private apiUrl = 'http://localhost:8082/Event'; // Adjust the URL as per your backend

  constructor(private http: HttpClient) { }

  getAllEvents(): Observable<evenement[]> {
    return this.http.get<evenement[]>(`${this.apiUrl}/getAll`);
  }
}
