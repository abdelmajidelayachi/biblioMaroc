package com.abdelmajidelayachi.libmaroc.book.dto.mapper;

import com.abdelmajidelayachi.libmaroc.book.dto.request.BookRequest;
import com.abdelmajidelayachi.libmaroc.book.dto.response.BookResponse;
import com.abdelmajidelayachi.libmaroc.book.entity.Book;
import com.abdelmajidelayachi.libmaroc.utils.mapper.EntityDtoMapper;

import java.util.List;

public class BookMapper {


    public static List<BookResponse> mapBookListToBookListDtoResponse(List<Book> bookList) {
        return bookList.stream().map(BookMapper::mapBookToBookDtoResponse).toList();
    }

    public static BookResponse mapBookToBookDtoResponse(Book book) {
        return EntityDtoMapper.toDto(book, BookResponse.class);
    }

    public static List<Book> mapBookRequestListDtoToBookEntityList(List<BookRequest> bookRequestList) {
        return bookRequestList.stream().map(BookMapper::mapBookRequestDtoToBookEntity).toList();
    }

    public static Book mapBookRequestDtoToBookEntity(BookRequest bookRequest) {
        return EntityDtoMapper.toEntity(bookRequest, Book.class);
    }


}
