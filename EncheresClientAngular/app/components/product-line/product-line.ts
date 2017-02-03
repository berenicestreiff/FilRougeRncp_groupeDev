import { Component, Input } from '@angular/core';
import { Product } from '../product/product';



const products: Product[] = [
  new Product(1, "armoirie XVe", "lorem psum", 22.588, 45.87),
  new Product(2, "armoirie XVIe", "lorem psum", 27.588, 46.87),
  new Product(3, "armoirie XVIIe", "lorem psum", 28.588, 47.87),
  new Product(4, "armoirie XVIIe", "lorem psum", 29.588, 48.87),
];

@Component({
  moduleId: module.id,
  selector: 'my-app',
  templateUrl: 'product-line.html',
   styleUrls: ['product-line.css']
})
export class AppComponent {
  products: Product[];
  selectedProduct: Product;

  constructor() {
    this.products = products;
    this.selectedProduct = null;
  }

  onProductSelect(id: number) {
    for (var i = 0; i < this.products.length; i++) {
      if (this.products[i].id == id) {
        this.selectedProduct = products[i];
        return;
      }
    }
    this.selectedProduct = null;
  }
}
