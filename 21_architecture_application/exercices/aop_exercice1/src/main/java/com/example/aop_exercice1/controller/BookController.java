package com.example.aop_exercice1.controller;

import com.example.aop_exercice1.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, String>> getAllBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody String title) {
        bookService.createBook(title);
        return new ResponseEntity<>(title, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getBookById(@PathVariable("id") int id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


}
