export class Calculator{

  id: number
  name: string
  cost: number


  constructor(json) {
    this.id = json['id'];
    this.name = json['name'];
    this.cost = json['cost'];
  }
}
