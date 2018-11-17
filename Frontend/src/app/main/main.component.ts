import {ApplicationRef, Component, ComponentFactoryResolver, Injector, OnInit} from '@angular/core';
import {ReviewRequest} from '../model/requests/review_request';
import {Review} from '../model/data/review';
import {HttpService} from '../http-service/http.service';
import {HttpClient} from '@angular/common/http';
import {Material} from "../model/data/material";
import {MaterialRequest} from "../model/requests/material_request";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  client: HttpService;

  reviews: Review[];
  materials: Material[];

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
    this.materials = null;

    const url: string = request.createQuery();
    console.log(url);

    this.client.get(url).subscribe(r => {
        this.reviews = r;
        console.log(r);
      },
      error => {
        console.log(error);
      });
  }

  getMaterials(request: MaterialRequest) {
    this.reviews = null;

    const url: string = request.createQuery();
    console.log(url);

    this.client.get(url).subscribe(r => {
        this.materials = r;
        console.log(r);
      },
      error => {
        console.log(error);
      });
  }

}
