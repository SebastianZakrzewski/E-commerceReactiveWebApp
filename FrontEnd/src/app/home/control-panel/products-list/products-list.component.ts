import {Component, OnInit} from '@angular/core';
import {Product} from "../../../Product";
import {MdbModalService} from "mdb-angular-ui-kit/modal";
import {ProductService} from "../../../services/product.service";
import {AddProductComponent} from "../../add-product/add-product.component";
import {ApiService} from "../../../services/api.service";

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {
  products!: Product[];

  constructor(private apiService:ApiService,private productService:ProductService, private modal:MdbModalService) {
  }
  addNewProduct() {
    this.modal.open(AddProductComponent);
  }
  ngOnInit(): void {
       this.apiService.getListOfObjects<Product>("/product").subscribe((listOfProducts) => {
        this.products = listOfProducts;

       })
       this.addProductToArray();
  }

  addProductToArray() {
     this.productService.productEvent.subscribe((value) =>
     {
       this.products.push(value);
     })
  }






  click() {

  }
}
