package com.book.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.book.web.model.Book;
import com.book.web.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Create a new book
    @PostMapping("/")
    public String createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return "Book saved successfully!";
    }

    // Retrieve all books
    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Retrieve a single book by ID
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    // Update a book
    @PutMapping("/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthorId(bookDetails.getAuthorId());
            book.setIsbn(bookDetails.getIsbn());
            book.setPublicationYear(bookDetails.getPublicationYear());
            bookRepository.save(book);
            return "Book updated successfully!";
        } else {
            return "Book not found with id " + id;
        }
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(id);
            return "Book deleted successfully!";
        } else {
            return "Book not found with id " + id;
        }
    }
}
