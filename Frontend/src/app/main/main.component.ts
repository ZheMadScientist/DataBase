import {ApplicationRef, Component, ComponentFactoryResolver, Injector, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {ReviewRequest} from '../model/requests/review_request';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  obs: Observable<any>;

  constructor(
    private componentFactoryResolver: ComponentFactoryResolver,
    private appRef: ApplicationRef,
    private injector: Injector
  ) { }

  ngOnInit() {
  }

  getReviews(request: ReviewRequest) {
    console.log(request.createQuery());
  }

}
