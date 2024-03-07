import { Routes } from '@angular/router';

import { DashboardComponent } from '../../dashboard/dashboard.component';
import { UserProfileComponent } from '../../user-profile/user-profile.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';
import { ProduitComponent } from 'app/produit/produit.component';
import { PropositionComponent } from 'app/proposition/proposition.component';
import { OffreFournisseurComponent } from 'app/offre-fournisseur/offre-fournisseur.component';
import {OffreComponent} from "../../offre/offre.component";
import {ActualiteComponent} from "../../actualite/actualite.component";
import {UpdateActualityComponent} from "../../update-actuality/update-actuality.component";

export const AdminLayoutRoutes: Routes = [
    // {
    //   path: '',
    //   children: [ {
    //     path: 'dashboard',
    //     component: DashboardComponent
    // }]}, {
    // path: '',
    // children: [ {
    //   path: 'userprofile',
    //   component: UserProfileComponent
    // }]
    // }, {
    //   path: '',
    //   children: [ {
    //     path: 'icons',
    //     component: IconsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'notifications',
    //         component: NotificationsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'maps',
    //         component: MapsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'typography',
    //         component: TypographyComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'upgrade',
    //         component: UpgradeComponent
    //     }]
    // }
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user-profile',   component: UserProfileComponent },
    { path: 'table-list',     component: TableListComponent },
    { path: 'typography',     component: TypographyComponent },
    { path: 'proposition',  component: PropositionComponent },
    { path: 'OffreFournisseur',  component: OffreFournisseurComponent },
    { path: 'produit',           component: ProduitComponent },
    { path: 'upgrade',        component: UpgradeComponent },
    { path: 'offre/:id1/:id2',        component: OffreComponent },
    { path: 'act',component: ActualiteComponent },
    { path: 'update/:id',component: UpdateActualityComponent },
];
