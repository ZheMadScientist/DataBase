import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MainComponent} from './main/main.component';
import { AddComponent } from './add/add.component';
import { ReviewComponent } from './review/review.component';
import {MatButtonModule, MatButtonToggleModule, MatCardModule, MatDatepickerModule, MatInputModule, MatNativeDateModule, MatSelectModule, MatTabsModule} from "@angular/material";

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    AddComponent,
    ReviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatTabsModule,
    MatButtonToggleModule,
    MatInputModule,
    MatSelectModule,
    MatNativeDateModule,
    MatDatepickerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
