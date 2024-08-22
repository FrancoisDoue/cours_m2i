package com.example.repository;

import com.example.entity.Borrow;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BorrowRepository implements PanacheRepository<Borrow> {

    public List<Borrow> findByBookId(Long bookId) {
        return list("bookId = :bookId", bookId);
    }

    public List<Borrow> findByUserId(Long userId) {
        return list("userId = :userId", userId);
    }

}
