package com.example.service;

import com.example.client.BookServiceClient;
import com.example.dto.BookDTO;
import com.example.entity.Author;
import com.example.repository.AuthorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class AuthorService {

    @Inject
    AuthorRepository authorRepository;

    @Inject @RestClient
    BookServiceClient bookServiceClient;

    private Author hydrateAuthor(Author author) {
        author.setBooks(bookServiceClient.findBooksByAuthorId(author.getId()));
        return author;
    }

    public List<Author> getAuthors() {
        return authorRepository.listAll().stream().map(this::hydrateAuthor).toList();
    }

    public Author getAuthorById(Long id) {
        return hydrateAuthor(authorRepository.findById(id));
    }

    @Transactional
    public Author createAuthor(Author author) {
        authorRepository.persist(author);
        return author;
    }

    @Transactional
    public Author updateAuthor(Long id, Author author) {
        Author updatedAuthor = authorRepository.findById(id);
        updatedAuthor.setFirstName(author.getFirstName());
        updatedAuthor.setLastName(author.getLastName());
        authorRepository.persist(updatedAuthor);
        return updatedAuthor;
    }

    @Transactional
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    
}
