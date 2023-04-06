package com.elayachiabdelmajid.libMaroc.book.services;


import com.elayachiabdelmajid.libMaroc.book.dto.request.BookRequest;
import com.elayachiabdelmajid.libMaroc.book.dto.response.BookResponse;
import com.elayachiabdelmajid.libMaroc.book.repository.BookRepository;
import com.elayachiabdelmajid.libMaroc.utils.mapper.EntityDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImp implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> EntityDtoMapper.toDto(book, BookResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void saveBook(BookRequest bookRequest) {

    }

    @Override
    public void updateBook(BookRequest bookRequest, Long idBook) {

    }

    @Override
    public void deleteBook() {

    }
}
