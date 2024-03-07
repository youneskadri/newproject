import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Evenement } from 'app/models/evenement';
import { EventService } from '../services/evenement.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { ReservationService } from '../services/reservation.service';
import { Reservation } from '../models/reservation';
import { Chart } from 'chart.js';


@Component({
  selector: 'app-evenementfront',
  templateUrl: './evenementfront.component.html',
  styleUrls: ['./evenementfront.component.css']
})
export class EvenementfrontComponent implements OnInit {
  evenements: Evenement[] = [];
  eventId!: number;

  constructor(private evenementService: EventService,
              private fb: FormBuilder,
              private http: HttpClient,
              private route: ActivatedRoute,
              private reservationService: ReservationService) { }

  ngOnInit(): void {
    this.loadEvenements();
    this.route.params.subscribe(params => {
      this.eventId = +params['id']; // Le '+' convertit la valeur en nombre
    });
  }

  loadEvenements() {
    this.evenementService.getAllEvenements().subscribe(
      (data: Evenement[]) => {
        this.evenements = data;
        console.log('Evenements:', data);
      },
      error => {
        console.error('Erreur lors de la récupération des événements', error);
      }
    );
  }

  searchFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("searchInput") as HTMLInputElement;
    filter = input.value.toUpperCase();
    table = document.getElementById("eventTable") as HTMLTableElement;
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td");
      for (var j = 0; j < td.length; j++) {
        if (td[j]) {
          txtValue = td[j].textContent || td[j].innerText;
          if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tr[i].style.display = "";
            break;
          } else {
            tr[i].style.display = "none";
          }
        }
      }
    }
  }

  sortTable(property: string) {
    this.evenements.sort((a, b) => {
      if (a[property] < b[property]) return -1;
      if (a[property] > b[property]) return 1;
      return 0;
    });
  }

  advancedSort(property: string, order: 'asc' | 'desc') {
    this.evenements.sort((a, b) => {
      const aValue = a[property];
      const bValue = b[property];
      
      if (order === 'asc') {
        if (aValue < bValue) return -1;
        if (aValue > bValue) return 1;
      } else if (order === 'desc') {
        if (aValue > bValue) return -1;
        if (aValue < bValue) return 1;
      }
      
      return 0;
    });
  }

  exportToCSV() {
    const csv = [];
    const rows = document.querySelectorAll("#eventTable tr");
    for (let i = 0; i < rows.length; i++) {
      const row = [];
      const cols = rows[i].querySelectorAll("td, th");
      for (let j = 0; j < cols.length; j++) {
        row.push(cols[j].textContent);
      }
      csv.push(row.join(","));
    }
    const csvContent = "data:text/csv;charset=utf-8," + csv.join("\n");
    const encodedUri = encodeURI(csvContent);
    const link = document.createElement("a");
    link.setAttribute("href", encodedUri);
    link.setAttribute("download", "events.csv");
    document.body.appendChild(link);
    link.click();
  }

 
  
   

  

 
  
}
