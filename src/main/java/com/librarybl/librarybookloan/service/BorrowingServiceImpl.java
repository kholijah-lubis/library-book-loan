package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.model.Borrowing;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    private final List<Borrowing> borrowings = new ArrayList<>();

    @Override
    public List<Borrowing> getAllBorrowings() {
        return borrowings;
    }

    @Override
    public Borrowing getBorrowingById(UUID id) {
        return borrowings.stream()
                .filter(borrowing -> borrowing.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Borrowing createBorrowing(Borrowing borrowing) {
        borrowing.setId(UUID.randomUUID());
        borrowings.add(borrowing);
        return borrowing;
    }

    @Override
    public Borrowing updateBorrowing(UUID id, Borrowing updatedBorrowing) {
        Borrowing existingBorrowing = getBorrowingById(id);
        if (existingBorrowing != null) {
            existingBorrowing.setBookId(updatedBorrowing.getBookId());
            existingBorrowing.setBorrowedId(updatedBorrowing.getBorrowedId());
            existingBorrowing.setBorrowedName(updatedBorrowing.getBorrowedName());
            existingBorrowing.setBorrowDate(updatedBorrowing.getBorrowDate());
            existingBorrowing.setReturnDate(updatedBorrowing.getReturnDate());
            return existingBorrowing;
        }
        return null;
    }

    @Override
    public void deleteBorrowing(UUID id) {
        Borrowing existingBorrowing = getBorrowingById(id);
        if (existingBorrowing != null) {
            borrowings.remove(existingBorrowing);
        }
    }
}
