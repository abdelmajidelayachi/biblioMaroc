import { Component, OnInit } from '@angular/core';
import { FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { faPenSquare, faTrash } from '@fortawesome/free-solid-svg-icons';
import { BookService } from 'src/app/services/book.service';
import { PaginationBookModel } from 'src/app/shared/models/book-model';

@Component({
  selector: 'app-books-admin',
  templateUrl: './books-admin.component.html',
  styleUrls: ['./books-admin.component.css']
})
export class BooksAdminComponent implements OnInit {

  paginationBooks !: PaginationBookModel;

  constructor(library: FaIconLibrary, private bookService: BookService) {
    library.addIcons(faPenSquare, faTrash);
    
  }

  ngOnInit(): void {
    this.bookService.getBooks(0, 10).subscribe((data) => {
      this.paginationBooks = data;
    })
  }

  handleDeleteBook(id: number){
    this.bookService.deleteBook(id).subscribe(() => {
      console.log('Book deleted');
    })
    }
  




}
