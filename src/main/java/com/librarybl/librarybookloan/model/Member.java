package com.librarybl.librarybookloan.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private String name;
    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy = "borrowed")
    private List<Borrowing> borrowings = new ArrayList<>();
}