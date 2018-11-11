import { Injectable } from '@angular/core';
import * as JsDiff from "diff";

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  text1: string = "1adsgdshasdhasdh";
  text2: string = "12312312312415325";

  diff = JsDiff.diffChars(this.text1, this.text2).map(d => d.value);

  constructor() { }
}
