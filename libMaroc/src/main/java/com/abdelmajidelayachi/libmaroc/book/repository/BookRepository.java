package com.abdelmajidelayachi.libmaroc.book.repository;

import com.abdelmajidelayachi.libmaroc.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    //
}
