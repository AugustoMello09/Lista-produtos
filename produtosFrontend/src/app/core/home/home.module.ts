import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { SharedModule } from '../shared/shared.module';
import { CriarComponent } from './components/criar/criar.component';
import { FormsModule } from '@angular/forms';
import { UpdateComponent } from './components/update/update.component';
import { DeleteComponent } from './components/delete/delete.component';


@NgModule({
  declarations: [
    HomeComponent,
    CriarComponent,
    UpdateComponent,
    DeleteComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    SharedModule,
    FormsModule
  ]
})
export class HomeModule { }
