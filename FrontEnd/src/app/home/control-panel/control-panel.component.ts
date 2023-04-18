import {Component, EventEmitter, Output} from '@angular/core';
import {ApiService} from "../../services/api.service";
import {MdbModalService} from "mdb-angular-ui-kit/modal";
import {AddProductComponent} from "../add-product/add-product.component";


@Component({
  selector: 'app-control-panel',
  templateUrl: './control-panel.component.html',
  styleUrls: ['./control-panel.component.css']
})
export class ControlPanelComponent {

  @Output() addProductEvent = new EventEmitter();
  constructor(private modal:MdbModalService,private apiService:ApiService) {
  }

  addNewProduct() {
    this.modal.open(AddProductComponent);
  }
}
