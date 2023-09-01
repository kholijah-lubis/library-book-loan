package com.librarybl.librarybookloan.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private String title;
    private String author;
    private int stockAvailable;

    @OneToMany(mappedBy = "book")
    private List<Borrowing> borrowings = new ArrayList<>();

}
