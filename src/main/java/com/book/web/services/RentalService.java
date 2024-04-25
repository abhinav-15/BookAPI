package com.book.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.web.model.Rental;
import com.book.web.repository.RentalRepository;

import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(Integer id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental updateRental(Integer id, Rental rentalDetails) {
        Rental rental = rentalRepository.findById(id).orElse(null);
        if (rental != null) {
            rental.setRenterName(rentalDetails.getRenterName());
            rental.setRentalDate(rentalDetails.getRentalDate());
            rental.setReturnDate(rentalDetails.getReturnDate());
            return rentalRepository.save(rental);
        }
        return null;
    }

    public boolean deleteRental(Integer id) {
        rentalRepository.deleteById(id);
		return true;
    }
}

