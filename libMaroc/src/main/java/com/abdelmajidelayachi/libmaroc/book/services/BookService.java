package com.abdelmajidelayachi.libmaroc.book.services;

import com.abdelmajidelayachi.libmaroc.book.dto.request.BookRequest;
import com.abdelmajidelayachi.libmaroc.book.dto.response.BookResponse;

import java.util.List;

public interface BookService {
    public List<BookResponse> getAllBooks();

    void saveBook(BookRequest bookRequest);

    void updateBook(BookRequest bookRequest, Long idBook);

    void deleteBook();
}
