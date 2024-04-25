package com.book.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.book.web.model.Author;
import com.book.web.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    // Create a new author
    @PostMapping("/")
    public String createAuthor(@RequestBody Author author) {
        authorRepository.save(author);
        return "Author saved successfully!";
    }

    // Retrieve all authors
    @GetMapping("/")
    public List <Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Retrieve a single author by ID
    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable Long id) {
        return authorRepository.findById(id);
    }

    // Update an author
    @PutMapping("/{id}")
    public String updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        Optional
        <Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            author.setName(authorDetails.getName());
            author.setBiography(authorDetails.getBiography());
            authorRepository.save(author);
            return "Author updated successfully!";
        } else {
            return "Author not found with id " + id;
        }
    }

    // Delete an author
    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            authorRepository.deleteById(id);
            return "Author deleted successfully!";
        } else {
            return "Author not found with id " + id;
        }
    }
}