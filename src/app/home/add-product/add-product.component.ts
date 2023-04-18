import {Component, EventEmitter, Input, Output} from '@angular/core';
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {ApiService} from "../../services/api.service";
import {ProductService} from "../../services/product.service";
import {Product} from "../../Product";
@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent {
         // @ts-ignore
         modalRef:MdbModalRef<AddProductComponent>;
         product: Product = {
         productName:'',
         productBrand:'',
         productCategory:'',
         price:0,dateTime:'',
         productImage:'',
         };
  constructor(private modal:MdbModalService,private productService:ProductService, private apiService:ApiService) {
  }
  click() {
    this.productService.addNewProduct(this.product);
    this.modalRef.close()
  }
  onFileChange($event: Event) {
  }
  onSubmit() {}

}
