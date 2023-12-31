package com.librarybl.librarybookloan.repository;

import com.librarybl.librarybookloan.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepositoryb extends JpaRepository<Book, UUID> {
}
