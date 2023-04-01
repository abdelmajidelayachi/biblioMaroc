package com.abdelmajidelayachi.libmaroc.book.services;

import com.abdelmajidelayachi.libmaroc.book.dto.mapper.BookMapper;
import com.abdelmajidelayachi.libmaroc.book.dto.request.BookRequest;
import com.abdelmajidelayachi.libmaroc.book.dto.response.BookResponse;
import com.abdelmajidelayachi.libmaroc.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return BookMapper.mapBookListToBookListDtoResponse(bookRepository.findAll());
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
