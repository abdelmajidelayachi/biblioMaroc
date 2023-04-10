package com.elayachiabdelmajid.libMaroc.book.repository;

import com.elayachiabdelmajid.libMaroc.book.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPaginationRepository extends PagingAndSortingRepository<Book, Long> {

}
