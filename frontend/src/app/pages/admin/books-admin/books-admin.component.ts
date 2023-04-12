import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { faPenSquare, faTrash } from '@fortawesome/free-solid-svg-icons';
import { map } from 'jquery';
import { Observable, Subject } from 'rxjs';
import { BookService } from 'src/app/services/book.service';
import { PaginationBookModel } from 'src/app/shared/models/book-model';

@Component({
  selector: 'app-books-admin',
  templateUrl: './books-admin.component.html',
  styleUrls: ['./books-admin.component.css']
})
export class BooksAdminComponent implements OnInit {

  @ViewChild('paginator') paginator !: MatPaginator;

  paginationBook$: Observable<PaginationBookModel> | undefined;
  currentPage = 0;
  sizeOfPage = 1;
  

  constructor(library: FaIconLibrary, private bookService: BookService) {
    library.addIcons(faPenSquare, faTrash);
    
  }

  ngOnInit(): void {
    this.paginationBook$ = this.bookService.getBooks(0, this.sizeOfPage);
  }

  handlePage(event: any){
    console.log(event);
    this.currentPage = event.pageIndex;
    this.sizeOfPage = event.pageSize;


    this.paginationBook$ = this.bookService.getBooks(event.pageIndex, this.sizeOfPage);
  }

  handleDeleteBook(id: number){
    this.bookService.deleteBook(id).subscribe(() => {
      console.log('Book deleted');
      console.log(this.paginator.getNumberOfPages());
      if(this.currentPage == 0){
        this.paginationBook$ = this.bookService.getBooks(this.currentPage, this.sizeOfPage);
        return;
      }
      if(this.paginator.getNumberOfPages() === this.currentPage + 1){
        this.currentPage = this.currentPage - 1;
        console.log(this.currentPage);
      }
      this.paginationBook$ = this.bookService.getBooks(this.currentPage, this.sizeOfPage);
    })
    }

    handleSavedBooked(event:boolean){
      if(event){
        console.log('Book saved');
        const lastPage = this.handleGetLastPage();
        this.currentPage = lastPage + 1;
        console.log(this.currentPage);
        this.paginationBook$ = this.bookService.getBooks(this.currentPage, this.sizeOfPage);
      }
    }


    handleGetLastPage(){
      const lastPage = this.paginator.getNumberOfPages();
      const size = this.paginator.pageSize;
      console.log(size);
      if(size === 1){
        return lastPage - 1;
      }
      return lastPage <= 0 ? 1 : lastPage;
    }

  
    




}
