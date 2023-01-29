import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import appRoutes from "./routerConfig";
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    DashboardComponent,
    NavbarComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes,{useHash: true})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
