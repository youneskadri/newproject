import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class EventService {
  constructor(private http:HttpClient) { }
  endpoint = `http://localhost:8082/Event/getAll`;
  getall(){
    return this.http.get<any>(this.endpoint);
  }

}
