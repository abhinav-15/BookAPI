package com.book.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.web.exception.ResourceNotFoundException;
import com.book.web.model.Book;
import com.book.web.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    
   public Book getBookById(Long id) {
        return bookRepository.findById(id)
                             .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
    }
    
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        // Update bookDetails attributes
        // e.g., book.setTitle(bookDetails.getTitle());
        // Set other attributes similarly
        return bookRepository.save(book);
    }
    
   public void deleteBook(Long id) {
       Book book = bookRepository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
       bookRepository.delete(book);
    }
}
        