import {API} from "../../const/api-url";

export class MaterialRequest implements GetRequest {

  name: string = null;
  description: string = null;
  tags: string[] = null;

  getAll: boolean = false;

  constructor(getAll: boolean) {
    this.getAll = getAll;
  }

  createQuery(): string {
    let res: string = API.getMaterialsUrl + '?';

    if (this.name != null) {
      res += '&' + 'name' + '=' + this.name;
    }
    if (this.description != null) {
      res += '&' + 'description' + '=' + this.description;
    }
    if (this.tags != null) {
      res += '&' + 'tags' + '=' + this.tags;
    }
    if (this.getAll) {
      res += '&' + 'getAll' + '=' + this.getAll;
    }

    return res;
  }

}
