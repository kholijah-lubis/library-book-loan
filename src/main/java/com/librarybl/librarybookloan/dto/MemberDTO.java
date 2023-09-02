package com.librarybl.librarybookloan.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MemberDTO {
    private UUID id;
    private String name;
    private String phoneNumber;
    private String address;
}
