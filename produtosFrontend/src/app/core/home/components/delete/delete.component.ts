import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ProductService } from 'src/app/core/service/product.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DeleteComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { id: number },
    private service: ProductService,
    private snack: MatSnackBar
  ) { }

  ngOnInit(): void {
  }

  public cancelar(): void {
    this.dialogRef.close();
  }

  public close(): void {
    this.dialogRef.close();
  }

  public deletar(): void {
    this.service.delete(this.data.id).subscribe(() => {
      this.dialogRef.close();
      this.snack.open('Produto deletado com sucesso', 'Success', {
        horizontalPosition: 'center',
        verticalPosition: 'bottom',
        duration: 3000
      });
    });
  }

}
