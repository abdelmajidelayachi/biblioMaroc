import { Component, HostListener, OnInit } from '@angular/core';
import { BlogService } from 'src/app/services/blog.service';
import { BlogModel, PaginationBlogModel } from 'src/app/shared/models/blog-model';

@Component({
  selector: 'app-blog-admin',
  templateUrl: './blog-admin.component.html',
  styleUrls: ['./blog-admin.component.css']
})
export class BlogAdminComponent implements OnInit {
  constructor(private blogService: BlogService) { }
  
  blogs: BlogModel[] = [];
  page = 0;
  size = 2;
  lastPage = 0;
  loading = false;
  ngOnInit(): void {
    this.getBlogs();
  }
  @HostListener('window:scroll', ['$event'])
  onScroll(event: any) {
    const windowHeight = 'innerHeight' in window ? window.innerHeight : document.documentElement.offsetHeight;
    const body = document.body;
    const html = document.documentElement;
    const docHeight = Math.max(body.scrollHeight, body.offsetHeight, html.clientHeight,  html.scrollHeight, html.offsetHeight);
    const windowBottom = windowHeight + window.pageYOffset;
    if (windowBottom >= docHeight && !this.loading) {
      this.page++;
      this.getBlogs();
    }
  }

  getBlogs() {
    this.loading = true;
    this.blogService.getBlogs(this.page, this.size)
      .subscribe((res: PaginationBlogModel) => {
        console.log(res);
        this.lastPage = res.totalPages;
        this.blogs.push(...res.content); // spread operator
        console.log(this.blogs);
        
        
        
        this.loading = false;
      });
  }
}
