import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarAdminComponent } from './shared/components/admin/navbar-admin/navbar-admin.component';
import { AdminComponent } from './pages/admin/admin.component';
import { HomeComponent } from './pages/home/home.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { AboutComponent } from './pages/about/about.component';
import { CategoryComponent } from './pages/category/category.component';
import { BlogComponent } from './pages/blog/blog.component';
import { ContactUsComponent } from './pages/contact-us/contact-us.component';
import { NavbarUserComponent } from './shared/components/user/navbar-user/navbar-user.component';
import { FooterUserComponent } from './shared/components/user/footer-user/footer-user.component';
import { CardComponent } from './shared/components/store/card/card.component';
import { StoreComponent } from './pages/store/store.component';
import { AuthComponent } from './pages/auth/auth.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { SidebarAdminComponent } from './shared/components/admin/sidebar-admin/sidebar-admin.component';
import { FooterAdminComponent } from './shared/components/admin/footer-admin/footer-admin.component';
import { BooksAdminComponent } from './pages/admin/books-admin/books-admin.component';
import { UsersComponent } from './pages/admin/users/users.component';
import { AddBookComponent } from './shared/components/modals/add-book/add-book.component';
import { FileUploadModule } from '@iplab/ngx-file-upload';
import { PostComponent } from './shared/components/post/post.component';
import { BlogAdminComponent } from './pages/admin/blog-admin/blog-admin.component';
import { OffersAdminComponent } from './pages/admin/offers-admin/offers-admin.component';
import { OfferCardComponent } from './shared/components/store/offer-card/offer-card.component';
import { LoaderComponent } from './shared/components/loader/loader.component';
import { MaterialComponentModule } from './core/modules/material-component.module';
import { AddPostComponent } from './shared/components/add-post/add-post.component';
import { HeaderInterceptor } from './core/interceptors/header.interceptor';
import { ErrorInterceptor } from './core/interceptors/error.interceptor';
import { AlertComponent } from './shared/components/alert/alert.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarAdminComponent,
    AdminComponent,
    HomeComponent,
    AboutComponent,
    CategoryComponent,
    BlogComponent,
    ContactUsComponent,
    NavbarUserComponent,
    FooterUserComponent,
    CardComponent,
    StoreComponent,
    AuthComponent,
    SidebarAdminComponent,
    FooterAdminComponent,
    BooksAdminComponent,
    UsersComponent,
    CardComponent,
    AddBookComponent,
    PostComponent,
    BlogAdminComponent,
    BlogAdminComponent,
    OffersAdminComponent,
    OfferCardComponent,
    LoaderComponent,
    AddPostComponent,
    AlertComponent
    
  ],
  imports: [
    BrowserModule,
    MaterialComponentModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    FontAwesomeModule,
    FileUploadModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HeaderInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
