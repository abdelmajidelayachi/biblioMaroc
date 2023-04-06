package com.elayachiabdelmajid.libMaroc.book.services;


import com.elayachiabdelmajid.libMaroc.book.dto.request.BookRequest;
import com.elayachiabdelmajid.libMaroc.book.dto.response.BookResponse;

import java.util.List;

public interface BookService {
    public List<BookResponse> getAllBooks();

    void saveBook(BookRequest bookRequest);

    void updateBook(BookRequest bookRequest, Long idBook);

    void deleteBook();
}
