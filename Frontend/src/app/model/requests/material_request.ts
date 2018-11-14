export class MaterialRequest implements GetRequest {

  name: string = null;
  description: string = null;

  tags: string[] = null;

  getAll: boolean = false;

  createQuery() {
    return '/get/reviews?' + 'name' + '=' + this.name
                     + '&' + 'description' + '=' + this.description
                     + '&' + 'tags' + '=' + this.tags
                     + '&' + 'getAll' + '=' + this.getAll;
  }

}
