import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor() {
  }

  static httpGet(url) {
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.responseType = 'json';
    xmlHttp.open("GET", url, false); // false for synchronous request
    xmlHttp.send();
    return xmlHttp.response
  }
}
