import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Review} from "../model/data/review";

@Component({
  selector: 'app-review-card',
  templateUrl: './review-card.component.html',
  styleUrls: ['./review-card.component.css']
})
export class ReviewCardComponent implements OnInit {

  @Input() review: Review;

  parseDateToView(): string {
    let res: string;

    if(this.review.reviewDate == null)
      return null;

    const day: string = this.review.reviewDate[2];
    const month: string = this.review.reviewDate[1];
    const year: string = this.review.reviewDate[0];

    res = day + '.' + month + '.' + year;

    return res;
  }

  constructor() {
  }

  ngOnInit() {
  }

}
