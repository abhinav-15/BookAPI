package com.book.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer authorId; // Assuming authorId is of type Long
    private String isbn;
    private Integer publicationYear;
    
    // Constructor
      public Book() {
		
	}
    
    @Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authorId=" + authorId + ", isbn=" + isbn
				+ ", publicationYear=" + publicationYear + "]";
	}

	// Getters and setters
    public Long getId() {
        return id;
    }

    public Book(Long id, String title, Integer authorId, String isbn, Integer publicationYear) {
		super();
		this.id = id;
		this.title = title;
		this.authorId = authorId;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
}
