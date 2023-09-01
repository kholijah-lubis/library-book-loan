package com.librarybl.librarybookloan.controller;

import com.librarybl.librarybookloan.repository.BookRepository;
import com.librarybl.librarybookloan.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

}
