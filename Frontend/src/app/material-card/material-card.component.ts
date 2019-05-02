import {Component, Input, OnInit} from '@angular/core';
import {Material} from "../model/data/material";

@Component({
  selector: 'app-material-card',
  templateUrl: './material-card.component.html',
  styleUrls: ['./material-card.component.css']
})
export class MaterialCardComponent implements OnInit {

  @Input() material: Material;

  constructor() { }

  ngOnInit() {
  }

}
