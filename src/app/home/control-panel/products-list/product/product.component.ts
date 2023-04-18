import {Component, Input, OnInit} from '@angular/core';
import {Product} from "../../../../Product";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  constructor() {
  }
  @Input() product!: Product;

  ngOnInit(): void {}



}
