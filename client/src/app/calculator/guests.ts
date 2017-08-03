export class Guests{

  id: number
  name: string
  surname: string


  constructor(json) {
    this.id = json['id'];
    this.name = json['name'];
    this.surname = json['surname'];
  }
}
