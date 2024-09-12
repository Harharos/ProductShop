import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { Product } from './product.class';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

    private products$: BehaviorSubject<Product[]> = new BehaviorSubject<Product[]>([]);

    private apiUrl = 'http://localhost:8081/products'; // Java API URL

    constructor(private http: HttpClient) { }

    getProducts(): Observable<Product[]> {
        this.http.get<Product[]>(this.apiUrl).subscribe(data => {
            this.products$.next(data);
        });
        return this.products$;
    }

    create(prod: Product): Observable<Product[]> {
        return this.http.post<Product[]>(this.apiUrl, prod).pipe(
            tap(() => this.getProducts()) // Refresh the product list after creation
        );
    }

    update(prod: Product): Observable<Product[]> {
        return this.http.patch<Product[]>(`${this.apiUrl}/${prod.id}`, prod).pipe(
            tap(() => this.getProducts()) // Refresh the product list after update
        );
    }

    delete(id: number): Observable<Product[]> {
        return this.http.delete<Product[]>(`${this.apiUrl}/${id}`).pipe(
            tap(() => this.getProducts()) // Refresh the product list after deletion
        );
    }
}
