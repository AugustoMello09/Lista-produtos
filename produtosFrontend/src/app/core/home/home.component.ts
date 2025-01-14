import { Component, OnInit } from '@angular/core';
import { Product } from '../shared/model/product.model';
import { ProductService } from '../service/product.service';
import { MatDialog } from '@angular/material/dialog';
import { CriarComponent } from './components/criar/criar.component';
import { UpdateComponent } from './components/update/update.component';
import { DeleteComponent } from './components/delete/delete.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public products: Product[] = [];

  constructor(private service: ProductService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.service.listAll();
    this.service.products$.subscribe((data) => {
      this.products = data;
      this.sortProducts();
    })
  }

  public open(): void {
    this.dialog.open(CriarComponent);
  }

  public delete(id: number): void {
    this.dialog.open(DeleteComponent, {
      data: { id: id }
    });
  }

  public update(id: number): void {
    this.dialog.open(UpdateComponent, { data: { id: id } })
      .afterClosed().subscribe((updatedTask: Product | null) => {
        if (updatedTask) {
          this.service.update(updatedTask); 
        }
      });
  }

  private sortProducts(): void {
    this.products.sort((a, b) => a.price - b.price);
  }
}
