package com.example.service;

import com.example.client.BookServiceClient;
import com.example.client.UserServiceClient;
import com.example.dto.BookDTO;
import com.example.entity.Borrow;
import com.example.repository.BorrowRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@ApplicationScoped
public class BorrowService {

    @Inject
    BorrowRepository borrowRepository;

    @Inject @RestClient
    BookServiceClient bookServiceClient;

    @Inject @RestClient
    UserServiceClient userServiceClient;

    private Borrow hydrateBorrow(Borrow borrow) {
        if (borrow.getBookId() == null || borrow.getUserId() == null)
            throw new WebApplicationException("Invalid borrow", 403);
        borrow.setBook(bookServiceClient.getBook(borrow.getBookId()));
        borrow.setUser(userServiceClient.getUser(borrow.getUserId()));
        if (borrow.getBook().getTitle() == null)
            throw new WebApplicationException("Fail to hydrate borrow", 500);
        return borrow;
    }

    public List<Borrow> getBorrows() {
        return borrowRepository.listAll().stream().map(this::hydrateBorrow).toList();
    }

    public List<Borrow> getBorrowsByUserId(Long userId) {
        return borrowRepository.findByUserId(userId).stream().map(this::hydrateBorrow).toList();
    }

    public List<Borrow> getBorrowsByBookId(Long bookId) {
        return borrowRepository.findByBookId(bookId).stream().map(this::hydrateBorrow).toList();
    }

    public List<Borrow> getNotReturnedBorrows() {
        return borrowRepository.findByReturnDateIsNull().stream().map(this::hydrateBorrow).toList();
    }

    public List<Borrow> getBorrowsBetweenDate(String fromToString, String toToString) {
        try {
            LocalDate from = LocalDate.parse(fromToString);
            LocalDate to = LocalDate.parse(toToString);
            return borrowRepository.findByBorrowDateBetween(from, to).stream()
                    .map(this::hydrateBorrow).toList();
        } catch (DateTimeParseException e) {
            throw new WebApplicationException("Fail to parse date", Response.Status.BAD_REQUEST);
        }
    }

    public Borrow getBorrowById(Long id) {
        return borrowRepository.findById(id);
    }

    @Transactional
    public Borrow createBorrow(Borrow borrow) {
        hydrateBorrow(borrow);
        BookDTO book = borrow.getBook();
        if (book.getQuantity() < 1)
            throw new WebApplicationException("Not available", 403);
        book.setQuantity(book.getQuantity() - 1);
        bookServiceClient.updateBook(book.getId(), book);
        borrowRepository.persist(borrow);
        return borrow;
    }

    @Transactional
    public Borrow closeBorrow(Long id) {
        Borrow borrow = borrowRepository.findById(id);
        if (borrow == null)
            throw new WebApplicationException("Not found", 404);
        if (borrow.getReturnDate() != null)
            throw new WebApplicationException("Already closed", 403);
        hydrateBorrow(borrow);
        BookDTO book = borrow.getBook();
        book.setQuantity(book.getQuantity() + 1);
        borrow.setReturnDate(LocalDate.now());
        bookServiceClient.updateBook(book.getId(), book);
        borrowRepository.persist(borrow);
        return borrow;
    }

    @Transactional
    public void deleteBorrow(Long id) {
        borrowRepository.deleteById(id);
    }

}
