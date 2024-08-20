package org.example.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;
import org.example.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    private int bookId = 0;

    private List<Book> books = new ArrayList<>(List.of(
            new Book(++bookId, "Livre 1", "Jim", 2005, "SF"),
            new Book(++bookId, "Livre 2", "John", 2018, "SF"),
            new Book(++bookId, "Livre 3", "Tom", 2020, "HORROR"),
            new Book(++bookId, "Livre 4", "George", 2023, "FANTASY"),
            new Book(++bookId, "Livre 5", "Bernard", 2000, "PHILOSOPHY")
    ));

    private void bookIsNotNull(Book book) {
        if (book == null) throw new IllegalArgumentException("Book is null");
    }

    public List<Book> getAll() {
        return books;
    }

    public Book create(Book book) {
        bookIsNotNull(book);
        book.setId(++bookId);
        books.add(book);
        return book;
    }

    public Optional<Book> get(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    public Book update(int id, Book book) {
        bookIsNotNull(book);
        Book bookToUpdate = get(id).orElseThrow(() -> new NotFoundException("Book not found"));
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setYear(book.getYear());
        bookToUpdate.setGenre(book.getGenre());
        return bookToUpdate;
    }

    public void delete(int id) {
        books.removeIf(b -> b.getId() == id);
    }

    public List<Book> findByAuthor(String author) {
        return books.stream().filter(b -> b.getAuthor().toLowerCase().startsWith(author.toLowerCase())).toList();
    }
}
