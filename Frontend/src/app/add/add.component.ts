import {Component, EventEmitter, Injector, Input, OnInit, Output} from '@angular/core';
import {ReviewRequest} from '../model/requests/review_request';
import {HashMap} from '../model/hash_map';
import {Review} from '../model/data/review';
import {API} from '../const/api-url';
import {HttpService} from '../http-service/http.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})

export class AddComponent implements OnInit {

  client: HttpService;

  map: HashMap;

  genderGET: string = null;

  fromAgeGET: number = null;
  toAgeGET: number = null;

  fromDateGET: string = null;
  toDateGET: string = null;

  tagsGET: string = null;


  userNamePost: string = null;
  userMiddleNamePost: string = null;
  userLastNamePost: string = null;
  userGenderPost: string = null;
  userAgePost: number = null;

  reviewDatePost: string = null;
  reviewContentPost: string = null;
  reviewTagsPost: string = null;

  @Output() onReviewRequest = new EventEmitter<ReviewRequest>();

  constructor(
    private injector: Injector
  ) {
    this.client = new HttpService(injector.get<HttpClient>(HttpClient));
  }

  ngOnInit() {
    this.initDateMapping();
  }

  postReview() {
    const url: string = API.postReviewUrl;

    console.log(url);

    this.client.post(url, this.mapReview()).subscribe(
      error => {
        console.log(error);
      });
  }

  mapReview(): Review {
    let review: Review = new Review();

    if (this.userAgePost != null)
      review.user.age = this.userAgePost;

    if(this.userGenderPost != null)
      review.user.gender = this.userGenderPost;

    if(this.userNamePost != null)
      review.user.name = this.userNamePost;

    if(this.userMiddleNamePost != null)
      review.user.middleName = this.userMiddleNamePost;

    if(this.userLastNamePost != null)
      review.user.lastName = this.userLastNamePost;

    if(this.reviewContentPost != null)
      review.content.content = this.reviewContentPost;

    if(this.reviewTagsPost != null)
      review.tags.tags = this.parseTags(this.reviewTagsPost);

    if(this.reviewDatePost != null)
      review.reviewDate = this.parseDateToPost(this.reviewDatePost.toString());

    return review;
  }

  getAllReviews() {
    const request = new ReviewRequest(true);
    this.onReviewRequest.emit(request);
  }

  sendRequest() {
    const request = new ReviewRequest(false);

    request.gender = this.genderGET;

    if (this.fromAgeGET != null)
      request.fromAge = this.fromAgeGET;

    if (this.toAgeGET != null)
      request.toAge = this.toAgeGET;

    if (this.fromDateGET != null)
      request.fromDate = this.parseDate(this.fromDateGET.toString());

    if (this.toDateGET != null)
      request.toDate = this.parseDate(this.toDateGET.toString());

    if (this.tagsGET != null)
      request.tags = this.parseTags(this.tagsGET);

    this.onReviewRequest.emit(request);
  }

  initDateMapping() {
    this.map = new HashMap();
    this.map.add('Jan', '01');
    this.map.add('Feb', '02');
    this.map.add('Mar', '03');
    this.map.add('Apr', '04');
    this.map.add('May', '05');
    this.map.add('Jun', '06');
    this.map.add('Jul', '07');
    this.map.add('Aug', '08');
    this.map.add('Sep', '09');
    this.map.add('Oct', '10');
    this.map.add('Nov', '11');
    this.map.add('Dec', '12');
  }

  //TODO: fix dis shit via moment lib

  parseDate(date: string): string {
    let res: string;

    const day: string = date.substr(8, 2);
    const month: string = this.map.get(date.substr(4, 3));
    const year: string = date.substr(11, 4);

    res = day + '.' + month + '.' + year;

    return res;
  }

  //such wow
  parseDateToPost(date: string) {
    let parsed: string = this.parseDate(date);

    let res: string;

    const day: string = parsed.substr(0, 2);
    const month: string = parsed.substr(3, 2);
    const year: string = parsed.substr(6, 4);

    res = year + '-' + month + '-' + day;

    return res;
  }

  parseTags(tags: string): string[] {
    tags = tags.trim();
    tags = tags.replace(/\s/g, '');
    tags = tags.replace('\n', ',');
    tags = tags.replace(';', ',');
    tags = tags.replace(',,', ',');

    return tags.split(',');
  }

}
