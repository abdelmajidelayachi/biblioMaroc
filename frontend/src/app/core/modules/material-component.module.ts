import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatToolbarModule } from '@angular/material/toolbar';

@NgModule({
  imports: [
    CommonModule,
    MatPaginatorModule,
    MatToolbarModule,
    MatButtonModule,
  ],
  exports: [
    MatPaginatorModule,
    MatToolbarModule,
    MatButtonModule,
  ],
  declarations: [],
  providers: [],
})
export class MaterialComponentModule { }
