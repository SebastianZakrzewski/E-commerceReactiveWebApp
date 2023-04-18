import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {Product} from "../Product";
import {ApiService} from "./api.service";


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  // @ts-ignore
  private createSubject: BehaviorSubject<Product> = new BehaviorSubject<Product>();

  // @ts-ignore
  public productEvent = this.createSubject.asObservable<Product>();
  constructor(private apiService:ApiService) {}

    addNewProduct(product: Product) {
    this.apiService.create(product,"/product/add").subscribe(
      {
        next: value => {
          this.createSubject.next(value);
        }

      })

  }

}
