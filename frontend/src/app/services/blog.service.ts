import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { endpoints } from '../shared/constants/endpoint';
import { PaginationBlogModel } from '../shared/models/blog-model';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  constructor(private http: HttpClient) { }

  saveBlog(formData: FormData) {
    return this.http.post(endpoints.blogs, formData);
  }

  getBlogs(page: number, size: number) {
    console.log(endpoints.blogsPagination(page, size));
    return this.http.get<PaginationBlogModel>(endpoints.blogsPagination(page, size));
  }

}
