import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import appRoutes from "./routerConfig";
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import {PostService} from "./services/post.services";

import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {PostModule} from "./index/post.module";

@NgModule({
  declarations: [

    AppComponent,
    HomeComponent,
    AboutComponent,
    DashboardComponent,
    NavbarComponent,
    FooterComponent,


  ],
  imports: [

    BrowserModule,HttpClientModule,PostModule, RouterModule.forRoot(appRoutes,{useHash: true}), FormsModule,
    ReactiveFormsModule
  ],
  providers: [PostService],
  bootstrap: [AppComponent]
})
export class AppModule { }
