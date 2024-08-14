package com.example.demo_hexa.domain.service;

import com.example.demo_hexa.domain.entity.Book;
import com.example.demo_hexa.shared.dto.BookDTO;
import com.example.demo_hexa.shared.port.BookPort;

import java.util.List;

public class BookService {

    private final BookPort bookPort;

    public BookService(BookPort bookPort) {
        this.bookPort = bookPort;
    }

    public Book save (String title, String author) {
        BookDTO book = new BookDTO(title, author);
        book = bookPort.save(book);
        return new Book(book.getId(), book.getTitle(), book.getAuthor());
    }

    public Book findById(int id) {
        BookDTO book = bookPort.findById(id);
        return new Book(book.getId(), book.getTitle(), book.getAuthor());
    }

    public List<Book> findAll() {
        return bookPort.findAll().stream().map(b -> new Book(b.getId(), b.getTitle(), b.getAuthor())).toList();
    }
}
