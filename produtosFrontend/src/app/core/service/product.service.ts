import { Injectable } from '@angular/core';
import { Product } from '../shared/model/product.model';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl: string = environment.baseUrl;

  private productSubject: BehaviorSubject<Product[]> = new BehaviorSubject<Product[]>([]);
  public products$: Observable<Product[]> = this.productSubject.asObservable();

  constructor(private http: HttpClient) { }

  public listAll(): void {
    const url = `${this.baseUrl}/v1/product`;
    this.http.get<Product[]>(url).subscribe((x) => {
      this.productSubject.next(x); 
    });
  }
}
