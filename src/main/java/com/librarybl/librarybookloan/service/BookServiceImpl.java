package com.librarybl.librarybookloan.service;

import com.librarybl.librarybookloan.model.Book;
import com.librarybl.librarybookloan.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(UUID id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            BeanUtils.copyProperties(updatedBook, existingBook, "id");
            return bookRepository.save(existingBook);
        }
        return null;
    }

    @Override
    public void deleteBook(UUID id) {
        Book bookToDelete = bookRepository.findById(id).orElse(null);
        if (bookToDelete != null) {
            bookRepository.delete(bookToDelete);
        }
    }
}
