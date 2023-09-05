package com.librarybl.librarybookloan.controller;

import com.librarybl.librarybookloan.dto.BorrowingDTO;
import com.librarybl.librarybookloan.model.Book;
import com.librarybl.librarybookloan.model.Borrowing;
import com.librarybl.librarybookloan.model.Member;
import com.librarybl.librarybookloan.service.BookService;
import com.librarybl.librarybookloan.service.BorrowingService;
import com.librarybl.librarybookloan.service.MemberService;
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

    @Autowired
    private BookService bookService; // Inject BookService
    @Autowired
    private MemberService memberService; // Inject MemberService

    @GetMapping
    public List<BorrowingDTO> getAllBorrowings() {
        List<BorrowingDTO> borrowingDTOs = borrowingService.getAllBorrowings();
        return borrowingDTOs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingDTO> getBorrowingById(@PathVariable UUID id) {
        BorrowingDTO borrowingDTO = borrowingService.getBorrowingDTOById(id);
        if (borrowingDTO != null) {
            return new ResponseEntity<>(borrowingDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BorrowingDTO> createBorrowing(@RequestBody BorrowingDTO borrowingDTO) {

        Book book = bookService.getBookById(borrowingDTO.getBookId());
        Member member = memberService.getMemberById(borrowingDTO.getMemberId());

        if (book != null && member != null) {

            Borrowing borrowing = new Borrowing();
            borrowing.setBook(book);
            borrowing.setBorrowedMember(member);
            borrowing.setBorrowDate(borrowingDTO.getBorrowDate());

            BorrowingDTO createdBorrowingDTO = borrowingService.createBorrowingDTO(borrowingDTO);
            if (createdBorrowingDTO != null) {
                return new ResponseEntity<>(createdBorrowingDTO, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowingDTO> updateBorrowing(@PathVariable UUID id, @RequestBody BorrowingDTO updatedBorrowingDTO) {
        BorrowingDTO updatedBorrowing = borrowingService.updateBorrowingDTO(id, updatedBorrowingDTO);
        if (updatedBorrowing != null) {
            return new ResponseEntity<>(updatedBorrowing, HttpStatus.OK);
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
