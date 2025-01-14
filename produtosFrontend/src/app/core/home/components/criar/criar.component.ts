import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ProductService } from 'src/app/core/service/product.service';
import { Product } from 'src/app/core/shared/model/product.model';

@Component({
  selector: 'app-criar',
  templateUrl: './criar.component.html',
  styleUrls: ['./criar.component.css']
})
export class CriarComponent implements OnInit {

  public product : Product = {
    id: '',
    name: '',
    description: '',
    available: '',
    price: 0
  }

  constructor(private service: ProductService,
    private dialogRef: MatDialogRef<CriarComponent>,
    private snack: MatSnackBar
  ) { }

  ngOnInit(): void {
  }

  public create(): void {
    this.service.create(this.product).subscribe(() => {
        this.dialogRef.close();
      }, (err: HttpErrorResponse) => { 
        this.addMessageError(err);
      })
  }  
  

  public message(msg: string): void {
    this.snack
      .open(`${msg}`, 'Error', {
        horizontalPosition: 'center',
        verticalPosition: 'bottom',
        duration: 8000
    })
  }

  public addMessageError(err: HttpErrorResponse) {
    if (err.status === 400) {
      this.message("Erro ao criar produto ");
    }
  }

}
