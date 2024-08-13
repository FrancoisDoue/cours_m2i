package com.example.demo_hexa.service;

import com.example.demo_hexa.entity.Book;
import com.example.demo_hexa.port.BookPort;

import java.util.List;

public class BookService {

    private final BookPort bookPort;

    public BookService(BookPort bookPort) {
        this.bookPort = bookPort;
    }

    public Book save (String title, String author) {
        Book book = new Book(title, author);
        return bookPort.save(book);
    }

    public Book findById(int id) {
        return bookPort.findById(id);
    }

    public List<Book> findAll() {
        return bookPort.findAll();
    }
}
