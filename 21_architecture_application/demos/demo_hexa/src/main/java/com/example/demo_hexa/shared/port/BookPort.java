package com.example.demo_hexa.port;

import com.example.demo_hexa.entity.Book;

import java.util.List;

public interface BookPort {
    Book save(Book book);
    List<Book> findAll();
    Book findById(int id);
}
