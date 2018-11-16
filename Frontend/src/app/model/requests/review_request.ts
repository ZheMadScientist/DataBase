export class ReviewRequest implements GetRequest {

  gender: string = null;

  fromAge: number = -1;
  toAge: number = -1;

  fromDate: string = null;
  toDate: string = null;

  tags: string[] = null;

  getAll: boolean = false;

  constructor(getAll: boolean) {
    this.getAll = getAll;
  }

  createQuery(): string {
    let res: string = '/get/reviews?'
            + 'fromAge' + '=' + this.fromAge
      + '&' + 'toAge' + '=' + this.toAge;

    if(this.gender != null)
      res += '&' + 'gender' + '=' + this.gender;

    if(this.fromDate != null)
      res += '&' + 'fromDate' + '=' + this.fromDate;

    if(this.toDate != null)
      res += '&' + 'fromDate' + '=' + this.toDate;

    if(this.tags != null)
      res += + '&' + 'tags' + '=' + this.tags;

    if(this.getAll)
      res += '&' + 'getAll' + '=' + this.getAll;

    return res;
  }
}
