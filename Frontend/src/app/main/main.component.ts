import {ApplicationRef, Component, ComponentFactoryResolver, Injector, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {ReviewRequest} from '../model/requests/review_request';
import {Review} from "../model/data/review";
import {API} from "../const/api-url";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  obs: Observable<any>;

  reviews: Review[];

  constructor(
    private componentFactoryResolver: ComponentFactoryResolver,
    private appRef: ApplicationRef,
    private injector: Injector
  ) {
  }

  ngOnInit() {
  }

  getReviews(request: ReviewRequest) {
    let url: string = API.appUrl + request.createQuery();
    // TODO: this.reviews = HttpService.httpGet(url);
    this.reviews = [
      {
        GUID: 1,
        user: {
          GUID: 2,
          name: "Lil",
          middleName: "Mouker",
          lastName: "Vert",
          age: 19,
          gender: "m"
        },
        content: {
          GUID: 3,
          content: "content of content"
        },
        tags: {
          GUID: 4,
          tags: ["tag1", "tag2", "anomaly"]
        },
        reviewDate: "2018,11,11"
      },
      {
        GUID: 5,
        user: {
          GUID: 6,
          name: "Lil",
          middleName: "Loxa",
          lastName: "Vert",
          age: 20,
          gender: "f"
        },
        content: {
          GUID: 7,
          content: "content of Loxa content"
        },
        tags: {
          GUID: 8,
          tags: ["tag1", "tag2", "anomaly"]
        },
        reviewDate: "2018,12,11"
      }];
  }

}
