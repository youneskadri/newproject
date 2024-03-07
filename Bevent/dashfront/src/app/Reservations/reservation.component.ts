import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reservation } from 'app/models/reservation';
import { ReservationService } from 'app/services/reservation.service';
import { Chart } from 'chart.js/auto';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  reservations: Reservation[] = [];
  selectedReservation: Reservation | null = null;
  reservationForm: FormGroup;
  isModified: boolean = false;
  reservationStats: any = {}; // Ajout d'un objet pour stocker les statistiques

  @ViewChild('chartCanvas') chartCanvas!: ElementRef;

  constructor(private reservationService: ReservationService, private fb: FormBuilder, private http: HttpClient) {
    this.reservationForm = this.fb.group({
      idreserv: [''],
      nomreserv: ['', Validators.required],
      nbrplace: ['', [Validators.required, Validators.min(1)]],
      type: ['', Validators.required],
      description: ['', Validators.required],
      datereserv: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadReservations();
  }

  loadReservations(): void {
    this.reservationService.getAllReservations().subscribe((reservations: Reservation[]) => {
      this.reservations = reservations;
      this.calculateStatistics(); // Calculer les statistiques après le chargement des réservations
    });
  }

  calculateStatistics(): void {
    this.reservationStats = {}; // Réinitialiser les statistiques
    this.reservations.forEach((reservation: Reservation) => {
      if (reservation.type in this.reservationStats) {
        this.reservationStats[reservation.type] += 1; // Incrémenter le nombre de réservations par type
      } else {
        this.reservationStats[reservation.type] = 1; // Initialiser le compteur à 1
      }
    });
    this.renderChart();
  }

  renderChart(): void {
    const ctx = this.chartCanvas.nativeElement.getContext('2d');
    const myChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: Object.keys(this.reservationStats),
        datasets: [{
          label: 'Nombre de réservations',
          data: Object.values(this.reservationStats),
          backgroundColor: 'rgba(75, 192, 192, 0.2)',
          borderColor: 'rgba(75, 192, 192, 1)',
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }

  selectReservation(reservation: Reservation): void {
    this.selectedReservation = { ...reservation };
    this.reservationForm.patchValue({
      idreserv: reservation.idreserv,
      nomreserv: reservation.nomreserv,
      nbrplace: reservation.nbrplace,
      type: reservation.type,
      description: reservation.description,
      datereserv: reservation.datereserv
    });
  }

  addReservation(): void {
    if (this.reservationForm.valid) {
      const reservation: Reservation = this.reservationForm.value;
      this.reservationService.addReservation(reservation).subscribe(() => {
        this.loadReservations();
        this.resetForm();
      });
    } else {
      this.reservationForm.markAllAsTouched();
    }
  }

  updateReservation(): void {
    if (this.selectedReservation && this.reservationForm.valid) {
      const updatedReservation: Reservation = this.reservationForm.value;
      this.selectedReservation.nomreserv = updatedReservation.nomreserv;
      this.selectedReservation.nbrplace = updatedReservation.nbrplace;
      this.selectedReservation.type = updatedReservation.type;
      this.selectedReservation.description = updatedReservation.description;
      this.selectedReservation.datereserv = updatedReservation.datereserv;

      this.reservationService.updateReservation(this.selectedReservation).subscribe(() => {
        this.loadReservations();
        this.selectedReservation = null;
        this.resetForm();
      });
    } else {
      this.reservationForm.markAllAsTouched();
    }
  }

  deleteReservation(idReservation: number): void {
    this.reservationService.deleteReservation(idReservation).subscribe(() => {
      this.loadReservations();
      this.selectedReservation = null;
    });
  }

  resetForm(): void {
    this.reservationForm.reset({
      idreserv: '',
      nomreserv: '',
      nbrplace: '',
      type: '',
      description: '',
      datereserv: ''
    });
  } 


  sendReservationEmail(reservation: Reservation): Observable<any> {
    const emailContent = `
      Bonjour,

      Une nouvelle réservation a été effectuée :
      - Nom du réservant : ${reservation.nomreserv}
      - Nombre de places : ${reservation.nbrplace}
      - Type de réservation : ${reservation.type}
      - Description : ${reservation.description}
      - Date de réservation : ${reservation.datereserv}

      Cordialement,
      Votre application de réservation
    `;

    return this.http.post<any>('URL_du_service_d_email', { content: emailContent });
  }
  
}
