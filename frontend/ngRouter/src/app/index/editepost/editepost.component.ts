import { Component } from '@angular/core';
import {PostService} from "../../services/post.services";
import {ActivatedRoute, Router} from "@angular/router";
import {Post} from "../../models/post";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-editepost',
  templateUrl: './editepost.component.html',
  styleUrls: ['./editepost.component.css']
})
export class EditepostComponent {
  id!: number;
  post!: Post;
  form!: FormGroup;

  /*------------------------------------------
  --------------------------------------------
  Created constructor
  --------------------------------------------
  --------------------------------------------*/
  constructor(
    public postService: PostService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  /**
   * Write code on Method
   *
   * @return response()
   */
  ngOnInit(): void {
    this.id = this.route.snapshot.params['postId'];
    this.postService.find(this.id).subscribe((data: Post)=>{
      this.post = data;
    });

    this.form = new FormGroup({
      title: new FormControl('', [Validators.required]),
      body: new FormControl('', Validators.required)
    });
  }

  /**
   * Write code on Method
   *
   * @return response()
   */
  get f(){
    return this.form.controls;
  }

  /**
   * Write code on Method
   *
   * @return response()
   */
  submit(){
    console.log(this.form.value);
    this.postService.update(this.id, this.form.value).subscribe((res:any) => {
      console.log('Post updated successfully!');
      this.router.navigateByUrl('post/index');
    })
  }
}
