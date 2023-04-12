import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { BooksAdminComponent } from './books-admin/books-admin.component';
import { UsersComponent } from './users/users.component';
import { BlogAdminComponent } from './blog-admin/blog-admin.component';
import { OffersAdminComponent } from './offers-admin/offers-admin.component';
import { AddPostComponent } from 'src/app/shared/components/add-post/add-post.component';

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
  { path: 'community', component: AdminComponent, children: [
    {path: '', pathMatch: 'full', redirectTo:'blogs'},
    { path: 'add-post', component: AddPostComponent },
    { path: 'blogs', component: BlogAdminComponent },
    { path: 'offers', component: OffersAdminComponent },
  ] },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
