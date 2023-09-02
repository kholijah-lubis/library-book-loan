package com.librarybl.librarybookloan.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeDTO {
    private UUID id;
    private String name;
    private String position;
}
