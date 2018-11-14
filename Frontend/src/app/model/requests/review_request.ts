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
    return String('/get/reviews?' + 'gender' + '=' + this.gender
                     + '&' + 'fromAge' + '=' + this.fromAge
                     + '&' + 'toAge' + '=' + this.toAge
                     + '&' + 'fromDate' + '=' + this.fromDate
                     + '&' + 'toDate' + '=' + this.toDate
                     + '&' + 'tags' + '=[' + this.tags + ']'
                     + '&' + 'getAll' + '=' + this.getAll);
  }
}
