package com.elayachiabdelmajid.libMaroc.book.repository;

import com.elayachiabdelmajid.libMaroc.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    //
}
