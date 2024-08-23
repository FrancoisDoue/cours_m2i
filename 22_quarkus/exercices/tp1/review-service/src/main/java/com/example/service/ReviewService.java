package com.example.service;

import com.example.client.BookServiceClient;
import com.example.client.UserServiceClient;
import com.example.entity.Review;
import com.example.repository.ReviewRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class ReviewService {

    @Inject
    ReviewRepository reviewRepository;

    @Inject @RestClient
    BookServiceClient bookServiceClient;

    @Inject @RestClient
    UserServiceClient userServiceClient;

    private Review hydrateReview(Review review) {
        if (review.getUserId() == null || review.getBookId() == null)
            throw new IllegalArgumentException("review or book id is null");
        review.setUser(userServiceClient.getUser(review.getUserId()));
        review.setBook(bookServiceClient.getBook(review.getBookId()));
        return review;
    }

    public List<Review> getReviews() {
        return reviewRepository.listAll().stream().map(this::hydrateReview).toList();
    }

    public List<Review> getReviewsByIsbn(String isbn) {
        return getReviews().stream()
                .filter(r -> r.getBook().getIsbn().equals(isbn))
                .toList();
    }

    public List<Review> getReviewsByUserName(String username) {
        return getReviews().stream()
                .filter(r -> r.getUser().getUsername().equals(username))
                .toList();
    }

    public Review getReview(Long id) {
        return hydrateReview(reviewRepository.findById(id));
    }

    public List<Review> getReviewsByNotationHigherThan(Integer notation) {
        return reviewRepository.findReviewsByNotationHigherThan(notation).stream()
                .map(this::hydrateReview).toList();
    }

    public List<Review> getReviewsByNotationLowerThan(Integer notation) {
        return reviewRepository.findReviewsByNotationLowerThan(notation).stream()
                .map(this::hydrateReview).toList();
    }


}
