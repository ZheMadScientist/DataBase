export class API {
  static readonly appUrl: string = 'http://195.225.57.253:48060';
  //static readonly appUrl: string = 'http://localhost:8080';

  // Get controller
  static readonly getUrl: string = API.appUrl + "/get";
  static readonly getMaterialsUrl: string = API.getUrl + "/materials";
  static readonly getReviewsUrl: string = API.getUrl + "/reviews";

  // Post controller
  static readonly postUrl: string = API.appUrl + "/persist";
  static readonly postMaterialUrl: string = API.postUrl + "/material";
  static readonly postReviewUrl: string = API.postUrl + "/review";
}
