import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { CategoryComponent } from './pages/category/category.component';
import { BlogComponent } from './pages/blog/blog.component';
import { ContactUsComponent } from './pages/contact-us/contact-us.component';
import { StoreComponent } from './pages/store/store.component';
import { AuthComponent } from './pages/auth/auth.component';
import { HeaderInterceptor } from './core/interceptors/header.interceptor';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {path: 'authentication', component: AuthComponent},
  { path: 'home', component: HomeComponent },
  {path: 'store', component: StoreComponent},
  {path: 'about', component: AboutComponent},
  {path: 'categories', component: CategoryComponent},
  {path: 'blog', component: BlogComponent},
  {path: 'contact-us', component: ContactUsComponent},
  {
    path: 'user', 
    loadChildren: () => import('./pages/user/user-routing.module').then(m => m.UserRoutingModule)
  },
  {
    path: 'management', 
    loadChildren: () => import('./pages/admin/admin-routing.module').then(m => m.AdminRoutingModule)
  },
];

//

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  providers: [HeaderInterceptor],
  exports: [RouterModule]
})
export class AppRoutingModule { }
