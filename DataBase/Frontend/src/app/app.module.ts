import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MainComponent} from './main/main.component';
import { AddComponent } from './add/add.component';
import {MatButtonModule, MatButtonToggleModule, MatCardModule, MatDatepickerModule, MatInputModule, MatNativeDateModule, MatSelectModule, MatTabsModule} from "@angular/material";
import { ReviewCardComponent } from './review-card/review-card.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { MaterialCardComponent } from './material-card/material-card.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    AddComponent,
    ReviewCardComponent,
    MaterialCardComponent
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
    MatDatepickerModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
