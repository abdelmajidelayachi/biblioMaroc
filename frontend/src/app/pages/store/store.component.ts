import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/services/book.service';
import { PaginationBookModel } from 'src/app/shared/models/book-model';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {

  paginationBooks !: PaginationBookModel;
  constructor (private bookService: BookService) {}
  ngOnInit(): void {
    this.bookService.getBooks(0, 10).subscribe((data) => {
      this.paginationBooks = data;
    })
  }

  

}
