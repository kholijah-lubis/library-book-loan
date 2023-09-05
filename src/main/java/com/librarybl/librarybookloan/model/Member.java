package com.librarybl.librarybookloan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy = "borrowedMember")
    private List<Borrowing> borrowings;

}
