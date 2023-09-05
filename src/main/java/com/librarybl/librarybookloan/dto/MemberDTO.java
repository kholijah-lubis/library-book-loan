package com.librarybl.librarybookloan.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class MemberDTO {
    private UUID id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 1, max = 100, message = "Name length must be between 1 and 100 characters")
    private String name;

    @NotNull(message = "PhoneNumber cannot be null")
    @NotBlank(message = "PhoneNumber cannot be blank")
    @Size(message = "min = 11, max = 12, message = PhoneNumber length must be between 11 and 12 characters")
    private String phoneNumber;

    @NotNull(message = "Address cannot be null")
    @NotBlank(message = "Address cannot be blank")
    @Size(min = 1, max = 100, message = "Address length must be between 1 and 100 characters")
    private String address;
}
