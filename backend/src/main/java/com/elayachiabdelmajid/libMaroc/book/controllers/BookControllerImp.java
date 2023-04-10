package com.elayachiabdelmajid.libMaroc.book.controllers;


import com.elayachiabdelmajid.libMaroc.book.dto.request.BookRequest;
import com.elayachiabdelmajid.libMaroc.book.dto.response.BookResponse;
import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;
import com.elayachiabdelmajid.libMaroc.book.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v1/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
public class BookControllerImp implements BookController{

    private final BookService bookService;

    @GetMapping("{page}/{size}")
    @Override
    public PaginationResponse<BookResponse> getBooksWithPagination(@PathVariable("page") int page, @PathVariable("size") int size) {
        return bookService.getPageBooks(page, size);
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void saveBook(@ModelAttribute BookRequest bookRequest) {
        log.info("saveBook", bookRequest);
        bookService.saveBook(bookRequest);
    }

    @PutMapping(value = "{idBook}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void updateBook(@ModelAttribute BookRequest bookRequest, Long idBook) {
        log.info("updateBook", bookRequest, idBook);
        bookService.updateBook(bookRequest, idBook);
    }


    @DeleteMapping("{idBook}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void deleteBook(@PathVariable("idBook") Long idBook) {
        log.info("deleteBook {}", idBook);
        bookService.deleteBook(idBook);
    }
}
