import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ReviewRequest} from '../model/requests/review_request';
import {HashMap} from '../model/hash_map';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})

export class AddComponent implements OnInit {

  map: HashMap;

  gender: string = null;

  fromAge: number = null;
  toAge: number = null;

  fromDate: string = null;
  toDate: string = null;

  tags: string = null;

  @Output() onReviewRequest = new EventEmitter<ReviewRequest>();

  constructor(
  ) { }

  ngOnInit() {
    this.initDateMapping()
  }

  getAllReviews() {
    const request = new ReviewRequest(true);
    this.onReviewRequest.emit(request);
  }

  sendRequest() {
    const request = new ReviewRequest(false);

    request.gender = this.gender;
    request.fromAge = this.fromAge;
    request.toAge = this.toAge;

    if(this.fromDate != null)
      request.fromDate = this.parseDate(this.fromDate.toString());

    if(this.toDate != null)
      request.toDate = this.parseDate(this.toDate.toString());

    if(this.tags != null)
      request.tags = this.parseTags(this.tags);

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

  parseDate(date: string): string {
    let res: string;

    let day: string = date.substr(8, 2);
    let month: string = this.map.get(date.substr(4, 3));
    let year: string = date.substr(11, 4);

    res = day + '.' + month + '.' + year;

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
