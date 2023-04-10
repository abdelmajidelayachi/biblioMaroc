import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { OfferComponent } from './offer/offer.component';
import { NavbarAdminComponent } from 'src/app/shared/components/admin/navbar-admin/navbar-admin.component';


@NgModule({
  declarations: [
    AdminComponent,
    OfferComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ],
  exports:[
    AdminComponent
  ]
})
export class AdminModule { }
