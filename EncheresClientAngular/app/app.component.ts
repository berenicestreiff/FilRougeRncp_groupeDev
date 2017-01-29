import { Component, Input } from '@angular/core';
import { Product } from './product';


/*

de selectedTache.titre ---> input.value
<input value="{{selectedTache.titre}}" placeholder="titre" />

 de selectedTache.titre ---> input.value
<input [value]="selectedTache.titre" placeholder="titre" />

on a besoin d'importer le module angularForm
et la directive Input
dans ce fichier -> Input depuis @angular/core
dans le fichier app.module
ajouter la dépendance au module @angular/form
pour du bidirectionnel
[(ngModel)]="selectedTache.titre"


d'un evenement html --> code typescript
(click)="onTacheSelect(tache.id)

cette directive desactive l'execution/rendu
de la balise si la condition est fausse
 <div *ngIf="selectedTache">

*/

const products: Product[] = [
  new Product(1, "armoirie XVe", "lorem psum", 22.588, 45.87),
  new Product(2, "armoirie XVIe", "lorem psum", 27.588, 46.87),
  new Product(3, "armoirie XVIIe", "lorem psum", 28.588, 47.87),
  new Product(4, "armoirie XVIIe", "lorem psum", 29.588, 48.87),
];

@Component({
  selector: 'my-app',
  template: `<h1>todoManager</h1>
            <h2>liste des produits</h2>
            <ul class="products">
              <li *ngFor="let product of products"
                (click)="onProductSelect(product.id)">
                <span class="badge bleft">{{product.id}}</span>
                {{product.designation}}
              </li>
            </ul>
            <product-details [product]="selectedProduct"></product-details>
            `,
  styles: [
    `
      .products {
        margin: 0 0 2em 0;
        list-style-type: none;
        padding: 0;
        width: 17em;
      }
      .products li {
        background-color: #EEE;
        position: relative;
        left: 0;
        margin: .5em;
        padding: .3em 0;
        height: 1.6em;
        border-radius: 4px;
      }
      .products .badge {
        font-size: small;
        display: inline-block;
        position: relative;
        line-height: 1em;
        padding: 0.8em 0.7em 0 0.7em;
        height: 1.8em;
        border-radius: 4px 4px 4px 4px;
        left: -1px;
        top: -4px;
      }
      .bleft {
        background-color: #607D8B;
        left: -1px;
        margin-right: .8em;
      }
      .bright {
        float: right;
        background-color: DarkSalmon;
      }
      .products li:hover {
        border: solid 2px blue;
      }
    `]
})
export class AppComponent {
  products: Product[];
  selectedProduct: Product;

  constructor() {
    this.products = products;
    this.selectedProduct = null;
  }

  onProductSelect(id: number) {
    for (var i = 0; i < this.tac.length; i++) {
      if (this.taches[i].id == id) {
        this.selectedTache = taches[i];
        return;
      }
    }
    this.selectedTache = null;
  }
}
