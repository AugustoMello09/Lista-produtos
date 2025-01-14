import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSnackBarModule } from '@angular/material/snack-bar';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatMenuModule,
    MatIconModule,
    MatDialogModule,
    MatSnackBarModule
  ],
  exports: [
    MatMenuModule,
    MatIconModule,
    MatDialogModule,
    MatSnackBarModule
  ],
})
export class MaterialModule { }
