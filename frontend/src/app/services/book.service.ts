import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PaginationBookModel } from '../shared/models/book-model';
import { endpoints } from '../shared/constants/endpoint';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getBooks(page: number, size: number){
    return this.http.get<PaginationBookModel>(endpoints.booksPagination(page, size))
  }

  deleteBook(id: number) {
    console.log(id);
    console.log('deleteBook', endpoints.deleteBook(id));
    return this.http.delete(endpoints.deleteBook(id));
  }
}
