import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { FileUploadValidators } from '@iplab/ngx-file-upload';
import { BlogService } from 'src/app/services/blog.service';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent {

  blogForm !: FormGroup;

  error : any;
  success: any;

  constructor(private fb: FormBuilder, private blogService: BlogService) {

    this.blogForm = this.fb.group({
      title: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      description: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(1000)]],
      images : new FormControl(null, [Validators.required, FileUploadValidators.filesLimit(5)]),
   })
  }

  get title() { return this.blogForm.get('title'); }
  get description() { return this.blogForm.get('description'); }
  get images() { return this.blogForm.get('images'); }

  onSubmitSaveBlog() {
    const formData =  new FormData();
    formData.append('title', this.title?.value);
    formData.append('description', this.description?.value);
    for(let i = 0; i < this.images?.value.length; i++) {
      formData.append('images', this.images?.value[i]);
    }

    this.blogService.saveBlog(formData).subscribe(
      (res) => {
        console.log(res);
        this.error = null;
        this.success = {
          message: 'Blog saved successfully'
        }

      }
      ,
      (error)=>{
        console.log(error);
        this.error = {
          message: error.error.message
        }
        this.success = null;
      }

    );


  }




}
