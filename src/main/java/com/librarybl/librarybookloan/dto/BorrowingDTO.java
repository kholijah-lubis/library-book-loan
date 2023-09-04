package com.librarybl.librarybookloan.dto;

import java.time.LocalDate;
import java.util.UUID;

public class BorrowingDTO {
    private UUID id;
    private UUID bookId;
    private UUID memberId;
    private String borrowedName;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private int fineAmount;
    private boolean returned;
}
