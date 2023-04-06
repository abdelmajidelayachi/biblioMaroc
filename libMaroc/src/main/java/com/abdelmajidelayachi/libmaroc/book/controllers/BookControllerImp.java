package com.abdelmajidelayachi.libmaroc.book.controllers;

import com.abdelmajidelayachi.libmaroc.book.dto.request.BookRequest;
import com.abdelmajidelayachi.libmaroc.book.dto.response.BookResponse;
import com.abdelmajidelayachi.libmaroc.book.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("api/v1/books")
@RequiredArgsConstructor
@RestController
public class BookControllerImp implements BookController{

    private final BookService bookService;

    @GetMapping
    @Override
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    @Override
    public void saveBook(BookRequest bookRequest) {
        bookService.saveBook(bookRequest);
    }

    @PutMapping("{idBook}")
    @Override
    public void updateBook(BookRequest bookRequest, Long idBook) {
        bookService.updateBook(bookRequest, idBook);
    }


    @DeleteMapping("{idBook}")
    @Override
    public void deleteBook(Long idBook) {
        bookService.deleteBook();
    }
}
