package com.elayachiabdelmajid.libMaroc.book.controllers;


import com.elayachiabdelmajid.libMaroc.book.dto.request.BookRequest;
import com.elayachiabdelmajid.libMaroc.book.dto.response.BookResponse;

import java.util.List;


public interface BookController {
    List<BookResponse> getAllBooks();
    void saveBook(BookRequest bookRequest);

    void updateBook(BookRequest bookRequest, Long idBook);

    void deleteBook(Long idBook);

}
