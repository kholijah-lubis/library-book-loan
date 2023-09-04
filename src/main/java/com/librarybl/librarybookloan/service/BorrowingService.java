package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.dto.BorrowingDTO;

import java.util.List;
import java.util.UUID;

public interface BorrowingService {
    List<BorrowingDTO> getAllBorrowings();

    BorrowingDTO getBorrowingDTOById(UUID id);

    BorrowingDTO createBorrowingDTO(BorrowingDTO borrowingDTO);

    BorrowingDTO updateBorrowingDTO(UUID id, BorrowingDTO updatedBorrowingDTO);

    void deleteBorrowing(UUID id);
}
