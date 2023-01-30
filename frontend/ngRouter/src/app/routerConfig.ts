import { Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {AboutComponent} from "./components/about/about.component";
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {IndexComponent} from "./index/index.component";

const appRoutes: Routes = [
  { path: 'index',
    component: IndexComponent
  },
  { path: 'home',
    component: HomeComponent
  },
  {
    path: 'about',
    component: AboutComponent
  },
  { path: 'dashboard',
    component: DashboardComponent
  }
];
export default appRoutes;
