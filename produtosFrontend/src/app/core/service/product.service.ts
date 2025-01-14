import { Injectable } from '@angular/core';
import { Product } from '../shared/model/product.model';
import { BehaviorSubject, Observable, tap } from 'rxjs';
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

  public create(product: any): Observable<Product> {
    const url = `${this.baseUrl}/v1/product`;
    return this.http.post<Product>(url, product).pipe(
      tap((newProduct) => {
        this.productSubject.next([...this.productSubject.value, newProduct]);
      })
    );
  }

  public delete(id: any): Observable<void>{
    const url = `${this.baseUrl}/v1/product/${id}`;
    return this.http.delete<void>(url).pipe(
      tap(() => {
        const x = this.productSubject.value.filter((x) => x.id !== id);
        this.productSubject.next(x);
      })
    );
  }

  public update(product: Product): Observable<Product> {
    const url = `${this.baseUrl}/v1/product/${product.id}`;
    return this.http.put<Product>(url, product).pipe(
      tap((updatedProduct) => {
        const updatedProducts = this.productSubject.value.map((p) =>
          p.id === updatedProduct.id ? updatedProduct : p
        );
        this.productSubject.next(updatedProducts);
      })
    );
  }

  public findById(id: any): Observable<Product>{
    const url = `${this.baseUrl}/v1/product/${id}`;
    return this.http.get<Product>(url);
  }
  
}
