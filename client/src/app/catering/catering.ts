export class Catering{

  id: number
  name: string
  kind:  string
    // [
    // {
    //   "DRINK":string
    // },
    // {
    //   "HOT_FOOD":string
    // },
    // {
    //   "STARTERS":string
    // }
    // ]


  constructor(json) {
    this.id = json['id'];
    this.name = json['name'];
    this.kind = json['kind'];
  }
}
