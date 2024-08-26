package com.example.repository;

import com.example.entity.Review;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ReviewRepository implements PanacheRepository<Review> {

    public List<Review> findReviewsByNotationHigherThan(Integer notation) {
        return list("notation >= ?1", notation);
    }

    public List<Review> findReviewsByNotationLowerThan(Integer notation) {
        return list("notation =< ?1", notation);
    }

    public List<Review> findReviewsByUserId(Long userId) {
        return list("userId = ?1", userId);
    }
}
