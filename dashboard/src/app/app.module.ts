import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { AppComponent } from './app.component';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { FrontOfficeModule } from './layouts/front-office/front-office.module';
import { PropositionComponent } from './proposition/proposition.component';
import { ProduitComponent } from './produit/produit.component';
import { FournisseurService } from './Service/fournisseur.service';
import { ProduitService } from './Service/serviceProduit/produit.service';
import { PropositionService } from './Service/serviceproposition/proposition.service';
import { OffreFournisseurComponent } from './offre-fournisseur/offre-fournisseur.component';
import { OffreFournisseurService } from './Service/serviceOffreFournisseur/offre-fournisseur.service';
import {MatSelectModule} from "@angular/material/select";
import { OffreComponent } from './offre/offre.component';
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import { ActualiteComponent } from './actualite/actualite.component';
import { UpdateActualityComponent } from './update-actuality/update-actuality.component';

@NgModule({
    imports: [
        BrowserAnimationsModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        ComponentsModule,
        RouterModule,
        AppRoutingModule,
        FrontOfficeModule,
        MatSelectModule,
        MatIconModule,
        MatButtonModule,
    ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    PropositionComponent,
    ProduitComponent,
    OffreFournisseurComponent,
    OffreComponent,
    ActualiteComponent,
    UpdateActualityComponent,

  ],
  providers: [FournisseurService, ProduitService,PropositionService,OffreFournisseurService],
  bootstrap: [AppComponent]
})
export class AppModule { }
