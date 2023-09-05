package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.dto.BorrowingDTO;
import com.librarybl.librarybookloan.model.Book;
import com.librarybl.librarybookloan.model.Borrowing;
import com.librarybl.librarybookloan.model.Member;
import com.librarybl.librarybookloan.repository.BorrowingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private BookService bookService; // Inject BookService
    @Autowired
    private MemberService memberService; // Inject MemberService

    @Override
    public List<BorrowingDTO> getAllBorrowings() {
        List<Borrowing> borrowings = borrowingRepository.findAll();
        List<BorrowingDTO> borrowingDTOs = new ArrayList<>();

        for (Borrowing borrowing : borrowings) {
            BorrowingDTO borrowingDTO = new BorrowingDTO();
            BeanUtils.copyProperties(borrowing, borrowingDTO);
            borrowingDTO.setBookId(borrowing.getBook().getId()); // Set Book ID
            borrowingDTO.setMemberId(borrowing.getBorrowedMember().getId()); // Set Member ID
            borrowingDTOs.add(borrowingDTO);
        }

        return borrowingDTOs;
    }

    @Override
    public BorrowingDTO getBorrowingDTOById(UUID id) {
        Borrowing borrowing = borrowingRepository.findById(id).orElse(null);
        if (borrowing != null) {
            BorrowingDTO borrowingDTO = new BorrowingDTO();
            BeanUtils.copyProperties(borrowing, borrowingDTO);
            borrowingDTO.setBookId(borrowing.getBook().getId()); // Set Book ID
            borrowingDTO.setMemberId(borrowing.getBorrowedMember().getId()); // Set Member ID
            return borrowingDTO;
        } else {
            return null;
        }
    }

    @Override
    public BorrowingDTO createBorrowingDTO(BorrowingDTO borrowingDTO) {

        Book book = bookService.getBookById(borrowingDTO.getBookId());
        Member member = memberService.getMemberById(borrowingDTO.getMemberId());

        if (book != null && member != null) {
            Borrowing borrowing = new Borrowing();
            BeanUtils.copyProperties(borrowingDTO, borrowing);
            borrowing.setBook(book);
            borrowing.setBorrowedMember(member);
            borrowing.setBorrowDate(borrowingDTO.getBorrowDate());

            Borrowing createdBorrowing = borrowingRepository.save(borrowing);

            if (createdBorrowing != null) {
                BorrowingDTO createdBorrowingDTO = new BorrowingDTO();
                BeanUtils.copyProperties(createdBorrowing, createdBorrowingDTO);
                createdBorrowingDTO.setBookId(createdBorrowing.getBook().getId()); // Set Book ID
                createdBorrowingDTO.setMemberId(createdBorrowing.getBorrowedMember().getId()); // Set Member ID
                return createdBorrowingDTO;
            }
        }
        return null;
    }

    @Override
    public BorrowingDTO updateBorrowingDTO(UUID id, BorrowingDTO updatedBorrowingDTO) {
        Borrowing existingBorrowing = borrowingRepository.findById(id).orElse(null);
        if (existingBorrowing != null) {

            BeanUtils.copyProperties(updatedBorrowingDTO, existingBorrowing);
            existingBorrowing.setId(id); // Pastikan ID tidak berubah
            existingBorrowing.setBook(bookService.getBookById(updatedBorrowingDTO.getBookId())); // Set Book
            existingBorrowing.setBorrowedMember(memberService.getMemberById(updatedBorrowingDTO.getMemberId())); // Set Member
            Borrowing updatedBorrowing = borrowingRepository.save(existingBorrowing);

            updatedBorrowingDTO = new BorrowingDTO();
            BeanUtils.copyProperties(updatedBorrowing, updatedBorrowingDTO);
            updatedBorrowingDTO.setBookId(updatedBorrowing.getBook().getId()); // Set Book ID
            updatedBorrowingDTO.setMemberId(updatedBorrowing.getBorrowedMember().getId()); // Set Member ID
            return updatedBorrowingDTO;
        }
        return null;
    }

    @Override
    public void deleteBorrowing(UUID id) {
        borrowingRepository.deleteById(id);
    }
}
