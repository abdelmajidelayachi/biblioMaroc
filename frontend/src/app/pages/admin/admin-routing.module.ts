import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { OfferComponent } from './offer/offer.component';
import { BooksAdminComponent } from './books-admin/books-admin.component';
import { UsersComponent } from './users/users.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'management' },
  { 
    path: 'management',
    component: AdminComponent,
    children: [
      {path: '', pathMatch: 'full', redirectTo:'books'},
      { path: 'books', component: BooksAdminComponent },
      { path: 'users', component: UsersComponent },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
