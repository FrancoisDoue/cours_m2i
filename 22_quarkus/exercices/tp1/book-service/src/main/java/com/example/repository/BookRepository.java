package com.example.repository;

import com.example.entity.Book;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {

    public List<Book> findByAuthorId(Long authorId) {
        return list("authorId", authorId);
    };

    public List<Book> findByIsbn(String isbn) {
        return list("isbn", isbn);
    }

}
