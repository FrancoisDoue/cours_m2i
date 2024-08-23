package com.example.repository;

import com.example.entity.Borrow;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class BorrowRepository implements PanacheRepository<Borrow> {

    public List<Borrow> findByBookId(Long bookId) {
        return list("bookId = ?1", bookId);
    }

    public List<Borrow> findByUserId(Long userId) {
        return list("userId = ?1", userId);
    }

    public List<Borrow> findByReturnDateIsNull() {
        return list("returnDate is null");
    }

    public List<Borrow> findByBorrowDateBetween(LocalDate from, LocalDate to) {
        return list("borrowDate between ?1 and ?2", from, to);
    }

}
