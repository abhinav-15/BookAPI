package com.book.web.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.web.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
