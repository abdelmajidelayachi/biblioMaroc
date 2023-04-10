package com.elayachiabdelmajid.libMaroc.book.controllers;


import com.elayachiabdelmajid.libMaroc.book.dto.request.BookRequest;
import com.elayachiabdelmajid.libMaroc.book.dto.response.BookResponse;
import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;



public interface BookController {
    PaginationResponse<BookResponse> getBooksWithPagination(int page, int size);

    void saveBook(BookRequest bookRequest);

    void updateBook(BookRequest bookRequest, Long idBook);

    void deleteBook(Long idBook);

}
