package com.elayachiabdelmajid.libMaroc.book.services;


import com.elayachiabdelmajid.libMaroc.book.dto.request.BookRequest;
import com.elayachiabdelmajid.libMaroc.book.dto.response.BookResponse;
import com.elayachiabdelmajid.libMaroc.book.dto.response.PaginationResponse;
import com.elayachiabdelmajid.libMaroc.book.entity.Book;
import com.elayachiabdelmajid.libMaroc.book.repository.BookPaginationRepository;
import com.elayachiabdelmajid.libMaroc.book.repository.BookRepository;
import com.elayachiabdelmajid.libMaroc.provider.CloudinaryProvider;
import com.elayachiabdelmajid.libMaroc.utils.mapper.EntityDtoMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImp implements BookService{

    private final BookRepository bookRepository;
    private final CloudinaryProvider cloudinaryProvider;
    private final BookPaginationRepository bookPaginationRepository;

    public BookServiceImp(BookRepository bookRepository, CloudinaryProvider cloudinaryProvider, BookPaginationRepository bookPaginationRepository) {
        this.bookRepository = bookRepository;
        this.cloudinaryProvider = cloudinaryProvider;
        this.bookPaginationRepository = bookPaginationRepository;
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> EntityDtoMapper.toDto(book, BookResponse.class)).collect(Collectors.toList());
    }
    @Override
    public void saveBook(BookRequest bookRequest) {
        MultipartFile[] images = bookRequest.getImages();
        String[] urls = storeImageInCloud(images);
        Book book = EntityDtoMapper.toEntity(bookRequest, Book.class);
        book.setImages(urls);
        bookRepository.save(book);
    }

    private String[] storeImageInCloud(MultipartFile[] images) {
        String[] urls = new String[images.length];
        for (int i = 0; i < images.length; i++) {
            System.out.println(images[i].getOriginalFilename());
            urls[i] = cloudinaryProvider.uploadImage(images[i]);
        }
        return urls;
    }


    @Transactional
    @Override
    public void updateBook(BookRequest bookRequest, Long idBook) {
        Book book = bookRepository.findById(idBook).orElseThrow(() -> new RuntimeException("Book not found"));
        if(bookRequest.getAuthor() != null) book.setAuthor(bookRequest.getAuthor());
        if(bookRequest.getPrice() != null) book.setPrice(bookRequest.getPrice());
        if(bookRequest.getName() != null) book.setName(bookRequest.getName());
    }

    @Override
    public void deleteBook(Long idBook) {
        Book book = bookRepository.findById(idBook).orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.delete(book);
    }

    @Override
    public PaginationResponse<BookResponse> getPageBooks(int page, int size) {
        Page<Book> bookPage = bookRepository.findAll(org.springframework.data.domain.PageRequest.of(page, size));
        return EntityDtoMapper.toDtoPageable(bookPage, BookResponse.class);
    }
}
