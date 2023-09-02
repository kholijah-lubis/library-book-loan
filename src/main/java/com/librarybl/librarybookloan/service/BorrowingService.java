package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.model.Borrowing;

import java.util.List;
import java.util.UUID;

public interface BorrowingService {
    List<Borrowing> getAllBorrowings();
    Borrowing getBorrowingById(UUID id);
    Borrowing createBorrowing(Borrowing borrowing);
    Borrowing updateBorrowing(UUID id, Borrowing updatedBorrowing);
    void deleteBorrowing(UUID id);
}
