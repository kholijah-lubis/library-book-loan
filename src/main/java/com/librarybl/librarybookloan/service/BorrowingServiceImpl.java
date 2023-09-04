package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.dto.BorrowingDTO;
import com.librarybl.librarybookloan.model.Borrowing;
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

    @Override
    public List<BorrowingDTO> getAllBorrowings() {
        List<Borrowing> borrowings = borrowingRepository.findAll();
        List<BorrowingDTO> borrowingDTOs = new ArrayList<>();

        for (Borrowing borrowing : borrowings) {
            BorrowingDTO borrowingDTO = new BorrowingDTO();
            BeanUtils.copyProperties(borrowing, borrowingDTO);
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
            return borrowingDTO;
        } else {
            return null;
        }
    }

    @Override
    public BorrowingDTO createBorrowingDTO(BorrowingDTO borrowingDTO) {
        Borrowing borrowing = new Borrowing();
        BeanUtils.copyProperties(borrowingDTO, borrowing);
        Borrowing createdBorrowing = borrowingRepository.save(borrowing);

        if (createdBorrowing != null) {
            BorrowingDTO createdBorrowingDTO = new BorrowingDTO();
            BeanUtils.copyProperties(createdBorrowing, createdBorrowingDTO);
            return createdBorrowingDTO;
        } else {
            return null;
        }
    }

    @Override
    public BorrowingDTO updateBorrowingDTO(UUID id, BorrowingDTO updatedBorrowingDTO) {
        Borrowing existingBorrowing = borrowingRepository.findById(id).orElse(null);
        if (existingBorrowing != null) {
            // Implementasi pembaruan peminjaman di sini
            // Anda dapat mengganti properti yang sesuai
            BeanUtils.copyProperties(updatedBorrowingDTO, existingBorrowing);
            existingBorrowing.setId(id); // Pastikan ID tidak berubah
            Borrowing updatedBorrowing = borrowingRepository.save(existingBorrowing);

            updatedBorrowingDTO = new BorrowingDTO();
            BeanUtils.copyProperties(updatedBorrowing, updatedBorrowingDTO);
            return updatedBorrowingDTO;
        }
        return null;
    }

    @Override
    public void deleteBorrowing(UUID id) {
        borrowingRepository.deleteById(id);
    }
}
