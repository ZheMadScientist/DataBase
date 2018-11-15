export class API {
  static readonly appUrl: string = '195.225.57.253:48060';

  // Get controller
  static readonly getUrl: string = API.appUrl + "/get";
  static readonly getMaterialsUrl: string = API.getUrl + "/materials";
  static readonly getReviewsUrl: string = API.getUrl + "/reviews";

  // Post controller
  static readonly postUrl: string = API.appUrl + "/persist";
  static readonly insertMaterialUrl: string = API.postUrl + "/material";
  static readonly insertReviewUrl: string = API.postUrl + "/review";
}
