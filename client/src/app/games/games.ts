export class Games{

  id: number
  name: string
  description: string


  constructor(json) {
    this.id = json['id'];
    this.name = json['name'];
    this.description = json['description'];
  }
}
