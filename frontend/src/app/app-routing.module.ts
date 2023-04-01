import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'user', 
    loadChildren: () => import('./pages/user/user-routing.module').then(m => m.UserRoutingModule)
  },
  {
    path: 'management', 
    loadChildren: () => import('./pages/admin/admin-routing.module').then(m => m.AdminRoutingModule)
  },
];

// structure will be like this :
/* actors
 |-> admin + monitor + manager  
 |-> gest + client + user

 /* file structure
├───app
│   ├───core
│   │   ├───guards {guest + admin + user}
│   │   ├───interceptors {headerInterceptor + errorInterceptor}
│   │   └───routes + adminRoute + UserRoute
│   ├───pages + admin + user
│   └───shared
│       ├───components + admin + user
│       ├───constants { endpoint }
│       └───models {}
└───assets
*/




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
