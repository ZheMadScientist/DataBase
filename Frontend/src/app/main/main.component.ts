import {ApplicationRef, Component, ComponentFactoryResolver, Injector, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {ReviewRequest} from '../model/requests/review_request';
import {Review} from '../model/data/review';
import {API} from '../const/api-url';
import {HttpService} from '../http-service/http.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  obs: Observable<any>;

  client: HttpService;

  reviews: Review[];

  constructor(
    private componentFactoryResolver: ComponentFactoryResolver,
    private appRef: ApplicationRef,
    private injector: Injector
  ) {

    this.client = new HttpService(injector.get<HttpClient>(HttpClient));

  }

  ngOnInit() {
  }

  getReviews(request: ReviewRequest) {
    const url: string = API.appUrl + request.createQuery();

    console.log(url);

    this.client.get(url).subscribe(r => {
        this.reviews = r;
        console.log(r);
      },
      error => {
        console.log(error);
      });
  }

}
