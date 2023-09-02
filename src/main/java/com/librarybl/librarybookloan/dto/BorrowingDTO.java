package com.librarybl.librarybookloan.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class BorrowingDTO {
    private UUID id;
    private Integer bookId;
    private Integer borrowedId;
    private String borrowedName;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
