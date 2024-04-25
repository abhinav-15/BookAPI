package com.book.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.web.model.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
    // Additional custom query methods can be defined here if needed
}

