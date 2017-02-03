
export class Product {
  id: number;
  designation: string;
  description: string;
  initialPrice: number;
  minimumAuction: number;

  constructor (id: number, designation: string, description: string, initialPrice: number, minimumAuction : number) {
    this.id = id;
    this.designation = designation;
    this.description = description;
    this.initialPrice = initialPrice;
    this.minimumAuction= minimumAuction;
  }
}