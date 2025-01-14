import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ProductService } from 'src/app/core/service/product.service';
import { Product } from 'src/app/core/shared/model/product.model';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  public product : Product = {
      id: '',
      name: '',
      description: '',
      available: '',
      price: 0
  }
  
  private originalProduct?: Product;

  constructor(public dialogRef: MatDialogRef<UpdateComponent>,
      @Inject(MAT_DIALOG_DATA) public data: { id: number },
      private service: ProductService,
      private snack: MatSnackBar) { }

  ngOnInit(): void {
    this.findById();
  }


  public findById(): void {
    this.service.findById(this.data.id).subscribe(result => {
      this.product = result;
      this.originalProduct = JSON.parse(JSON.stringify(result));
    });
  }

  public update(): void {
    const verify = JSON.stringify(this.product) === JSON.stringify(this.originalProduct);
    if (verify) {
      this.dialogRef.close();
      return;
    }
    this.service.update(this.product).subscribe(result => {
      this.product = result;
      this.snack.open('Produto atualizado com sucesso', 'Success', {
        horizontalPosition: 'center',
        verticalPosition: 'bottom',
        duration: 3000
      });
      this.dialogRef.close();
    })
  }
}
