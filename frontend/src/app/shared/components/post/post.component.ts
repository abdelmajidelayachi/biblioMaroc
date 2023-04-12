import { Component, HostListener, Input } from '@angular/core';
import { BlogService } from 'src/app/services/blog.service';
import { BlogModel, PaginationBlogModel } from '../../models/blog-model';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent {

  @Input() blog !: BlogModel;

  
}
