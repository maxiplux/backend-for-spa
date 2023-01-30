import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PostRoutingModule } from './post-routing.module';


import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {IndexComponent} from "./index.component";
import {ViewpostComponent} from "./viewpost/viewpost.component";
import {CreatepostComponent} from "./createpost/createpost.component";
import {EditepostComponent} from "./editepost/editepost.component";

@NgModule({
  declarations: [IndexComponent, ViewpostComponent, CreatepostComponent, EditepostComponent],
  imports: [
    CommonModule,
    PostRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class PostModule { }
