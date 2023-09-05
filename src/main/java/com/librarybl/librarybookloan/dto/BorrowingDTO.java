package com.librarybl.librarybookloan.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class BorrowingDTO {
    private UUID id;
    private UUID bookId;
    private UUID memberId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private int fineAmount;
    private boolean returned;
}
