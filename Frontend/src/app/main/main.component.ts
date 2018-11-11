import { Component, OnInit } from '@angular/core';
import * as JsDiff from 'diff'

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  text1: string = "1adsgdshasdhasdh";
  text2: string = "12312312312415325";

  diff = JsDiff.diffChars(this.text1, this.text2).map(d => d.value);


  constructor() { }

  ngOnInit() {

  }

}
