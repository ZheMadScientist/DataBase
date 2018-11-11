export class API {
  readonly appUrl: string = '195.225.57.253:48060';

  // Get controller
  readonly getUrl: string = this.appUrl + "/get";
  readonly getMaterialsUrl: string = this.getUrl + "/materials";
  readonly getReviewsUrl: string = this.getUrl + "/reviews";

  // Post controller
  readonly postUrl: string = this.appUrl + "/persist";
  readonly insertMaterialUrl: string = this.postUrl + "/material";
  readonly insertReviewUrl: string = this.postUrl + "/review";
}
