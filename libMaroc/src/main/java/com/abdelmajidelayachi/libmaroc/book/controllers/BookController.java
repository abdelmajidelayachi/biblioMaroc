package com.abdelmajidelayachi.libmaroc.book.controllers;

import com.abdelmajidelayachi.libmaroc.book.dto.request.BookRequest;
import com.abdelmajidelayachi.libmaroc.book.dto.response.BookResponse;

import java.util.List;


public interface BookController {
    List<BookResponse> getAllBooks();
    void saveBook(BookRequest bookRequest);

    void updateBook(BookRequest bookRequest, Long idBook);

    void deleteBook(Long idBook);

}
