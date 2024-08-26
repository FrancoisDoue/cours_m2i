package com.example.service;

import com.example.client.AuthorServiceClient;
import com.example.dto.AuthorDTO;
import com.example.entity.Book;
import com.example.repository.BookRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class BookService {

    @Inject
    BookRepository bookRepository;

    @Inject @RestClient
    AuthorServiceClient authorServiceClient;

    private Book hydrateBook(Book book) {
        if (book.getAuthorId() != null){
            book.setAuthor(authorServiceClient.getAuthorById(book.getAuthorId()));
        }
        return book;
    }

    public List<Book> getBooks() {
        return bookRepository.listAll().stream().map(this::hydrateBook).toList();
    }

    public List<Book> getBooksByAuthorId(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public Book getBookById(Long id) {
        return hydrateBook(bookRepository.findById(id));
    }

    public List<Book> getBooksByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Transactional
    public Book createBook(Book book) {
        if (book.getAuthorId() != null) {
            AuthorDTO authorDTO = authorServiceClient.getAuthorById(book.getAuthorId());
            book.setAuthor(authorDTO);
        } else {
            if (book.getAuthor() == null) throw new WebApplicationException("Author is required", 403);
            AuthorDTO authorDTO = authorServiceClient.createAuthor(book.getAuthor());
            book.setAuthor(authorDTO);
            book.setAuthorId(authorDTO.getId());
        }
        bookRepository.persist(book);
        return book;
    }

    @Transactional
    public Book updateBook(Long id, Book book) {
        Book updatedBook = bookRepository.findById(id);
        updatedBook.setTitle(book.getTitle());
        updatedBook.setIsbn(book.getIsbn());
        updatedBook.setQuantity(book.getQuantity());
        bookRepository.persist(updatedBook);
        return updatedBook;
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
