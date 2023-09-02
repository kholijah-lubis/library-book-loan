package com.librarybl.librarybookloan.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BookDTO {
    private UUID id;
    private String title;
    private String author;
    private int stockAvailable;
}
