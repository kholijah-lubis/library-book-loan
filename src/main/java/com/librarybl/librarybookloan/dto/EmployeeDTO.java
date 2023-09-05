package com.librarybl.librarybookloan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class EmployeeDTO {
    private UUID id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 1, max = 100, message = "Name length must be between 1 and 100 characters")
    private String name;

    @NotNull(message = "Position cannot be null")
    @NotBlank(message = "Position cannot be blank")
    @Size(min = 1, max = 100, message = "Position length must be between 1 and 100 characters")
    private String position;
}
