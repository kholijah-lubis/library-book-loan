package com.librarybl.librarybookloan.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Data
@Entity
@Table(name = "borrowing")
public class Borrowing {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member borrowedMember;

    private LocalDate borrowDate;
    private LocalDate returnDate;
    private int fineAmount;
    private boolean returned;

    public Borrowing() {
        this.id = UUID.randomUUID();
    }

    public void setReturnDateAutomatically() {
        this.returnDate = LocalDate.now().plusWeeks(1);
    }

    public void calculateFine() {
        if (returned && returnDate.isBefore(LocalDate.now())) {
            long daysLate = ChronoUnit.DAYS.between(returnDate, LocalDate.now());
            fineAmount = (int) (daysLate * 1000);
        } else {
            fineAmount = 0;
        }
    }
}
