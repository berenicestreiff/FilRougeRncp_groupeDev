import { Component , Input} from '@angular/core';
import { Product } from'../product/product';

@Component({
    selector: 'product-details',
    template: `product-detail.html `
})
export class ProductDetailsComponent {
   
    @Input()
    product: Product;
}