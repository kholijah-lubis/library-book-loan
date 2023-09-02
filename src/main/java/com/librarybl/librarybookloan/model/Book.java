package com.librarybl.librarybookloan.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
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

    // Konstruktor dengan argumen
    public Book(String title, String author, int stockAvailable) {
        this.title = title;
        this.author = author;
        this.stockAvailable = stockAvailable;
    }

}
