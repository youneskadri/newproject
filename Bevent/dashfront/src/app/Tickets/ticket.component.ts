import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Ticket } from 'app/models/ticket';
import { TicketService } from 'app/services/ticket.service';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {
  tickets: Ticket[] = [];
  selectedTicket: Ticket | null = null;
  ticketForm: FormGroup;
isModified: any;

  constructor(private ticketService: TicketService, private fb: FormBuilder) {
    this.ticketForm = this.fb.group({
      nbrticket: ['', Validators.required],
      type: ['', Validators.required],
      prix: ['', Validators.required],
      description: ['', Validators.required],
      numero: ['', Validators.required],
      datevente: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.loadTickets();
  }

  loadTickets(): void {
    this.ticketService.getAllTickets().subscribe((tickets: Ticket[]) => {
      this.tickets = tickets;
    });
  }

  selectTicket(ticket: Ticket): void {
    this.selectedTicket = ticket;
    this.ticketForm.patchValue({
      nbrticket: ticket.nbrticket,
      type: ticket.type,
      prix: ticket.prix,
      description: ticket.description,
      numero: ticket.numero,
      datevente: ticket.datevente
    });
  }

  addTicket(): void {
    if (this.ticketForm.valid) {
      const ticket: Ticket = this.ticketForm.value;
      this.ticketService.addTicket(ticket).subscribe(() => {
        this.loadTickets();
        this.resetForm();
      });
    } else {
      this.ticketForm.markAllAsTouched();
    }
  }

  updateTicket(): void {
    if (this.selectedTicket && this.ticketForm.valid) {
      const updatedTicket: Ticket = this.ticketForm.value;
      updatedTicket.idticket = this.selectedTicket.idticket; // Assurez-vous que l'identifiant du ticket est conservé
      this.ticketService.updateTicket(updatedTicket).subscribe(() => {
        this.loadTickets();
        this.selectedTicket = null;
        this.resetForm();
      });
    } else {
      this.ticketForm.markAllAsTouched();
    }
  }

  deleteTicket(idTicket: number): void {
    this.ticketService.deleteTicket(idTicket).subscribe(() => {
      this.loadTickets();
      this.selectedTicket = null;
    });
  }

  resetForm(): void {
    this.ticketForm.reset({
      nbrticket: '',
      type: '',
      prix: '',
      description: '',
      numero: '',
      datevente: ''
    });
  }
}
