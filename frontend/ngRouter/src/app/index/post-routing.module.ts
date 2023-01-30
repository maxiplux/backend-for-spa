import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {IndexComponent} from "./index.component";
import {ViewpostComponent} from "./viewpost/viewpost.component";
import {CreatepostComponent} from "./createpost/createpost.component";
import {EditepostComponent} from "./editepost/editepost.component";


const routes: Routes = [
  { path: 'post', redirectTo: 'post/index', pathMatch: 'full'},
  { path: 'post/index', component: IndexComponent },
  { path: 'post/:postId/view', component: ViewpostComponent },
  { path: 'post/create', component: CreatepostComponent },
  { path: 'post/:postId/edit', component: EditepostComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PostRoutingModule { }
