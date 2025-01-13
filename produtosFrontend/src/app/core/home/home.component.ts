import { Component, OnInit } from '@angular/core';
import { Product } from '../shared/model/product.model';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public products: Product[] = [];

  constructor(private service: ProductService) { }

  ngOnInit(): void {
    this.service.listAll();
    this.service.products$.subscribe((data) => {
      this.products = data
    })
  }

  public open(): void {

  }

  public delete(id: number): void {
   
  }

  public update(id: number): void {
    
  }


}
