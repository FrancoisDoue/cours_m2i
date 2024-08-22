package com.example.service;

import com.example.client.BookServiceClient;
import com.example.client.UserServiceClient;
import com.example.entity.Borrow;
import com.example.repository.BorrowRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

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
        borrow.setBook(bookServiceClient.getBook(borrow.getBookId()));
        borrow.setUser(userServiceClient.getUser(borrow.getUserId()));
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

    public Borrow getBorrowById(Long id) {
        return borrowRepository.findById(id);
    }




}
