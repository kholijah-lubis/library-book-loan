package com.librarybl.librarybookloan.controller;

import com.librarybl.librarybookloan.model.Borrowing;
import com.librarybl.librarybookloan.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @GetMapping
    public ResponseEntity<List<Borrowing>> getAllBorrowings() {
        List<Borrowing> borrowings = borrowingService.getAllBorrowings();
        return new ResponseEntity<>(borrowings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrowing> getBorrowingById(@PathVariable UUID id) {
        Borrowing borrowing = borrowingService.getBorrowingById(id);
        if (borrowing != null) {
            return new ResponseEntity<>(borrowing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Borrowing> createBorrowing(@RequestBody Borrowing borrowing) {
        Borrowing createdBorrowing = borrowingService.createBorrowing(borrowing);
        return new ResponseEntity<>(createdBorrowing, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrowing> updateBorrowing(@PathVariable UUID id, @RequestBody Borrowing updatedBorrowing) {
        Borrowing borrowing = borrowingService.updateBorrowing(id, updatedBorrowing);
        if (borrowing != null) {
            return new ResponseEntity<>(borrowing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowing(@PathVariable UUID id) {
        borrowingService.deleteBorrowing(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
