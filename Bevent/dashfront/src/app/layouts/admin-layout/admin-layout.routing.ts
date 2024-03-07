import { Routes } from '@angular/router';

import { DashboardComponent } from '../../dashboard/dashboard.component';
import { UserProfileComponent } from '../../user-profile/user-profile.component';
import { TableListComponent } from '../../Evenements/table-list.component';
import { TicketComponent } from '../../Tickets/ticket.component';
import { ReservationComponent } from '../../Reservations/reservation.component';
import { CalendarComponent } from '../../maps/calender.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';
import { FileComponent } from 'app/file/file.component';

export const AdminLayoutRoutes: Routes = [
   
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user-profile',   component: UserProfileComponent },
    { path: 'table-list',     component: TableListComponent },
    { path: 'ticket',         component: TicketComponent },
    { path: 'icons',          component: ReservationComponent },
    { path: 'calendar',       component: CalendarComponent },
    { path: 'notifications',  component: NotificationsComponent },
    { path: 'upgrade',        component: UpgradeComponent },
    { path: 'file',           component: FileComponent },

];
