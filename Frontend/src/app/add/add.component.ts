import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})

export class AddComponent implements OnInit {

  @Input() userName: string;
  @Input() picker: string;
  material: boolean;

  @Output() getAllClicked = new EventEmitter<boolean>();

  constructor(
  ) { }

  ngOnInit() {
  }

  getAll() {
    this.getAllClicked.emit(true);
  }

}
