import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { OfferComponent } from './offer/offer.component';

const routes: Routes = [
  { 
    path: '',
    component: AdminComponent,
    children: [
      { path: '', component: OfferComponent },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
