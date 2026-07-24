package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.request.CreateReviewRequestDto;
import com.winemood.winemood_backend.dto.response.ReviewResponseDto;
import com.winemood.winemood_backend.dto.response.UserReviewResponseDto;
import com.winemood.winemood_backend.entity.Review;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.exceptions.ReviewAlreadyExistsException;
import com.winemood.winemood_backend.exceptions.ReviewNotFoundException;
import com.winemood.winemood_backend.exceptions.WineNotFoundException;
import com.winemood.winemood_backend.mapper.ReviewMapper;
import com.winemood.winemood_backend.repository.ReviewRepository;
import com.winemood.winemood_backend.repository.WineRepository;
import com.winemood.winemood_backend.service.AuthenticatedUserService;
import com.winemood.winemood_backend.service.ReviewService;
import org.springframework.security.access.AccessDeniedException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final WineRepository wineRepository;
    private final AuthenticatedUserService authenticatedUserService;
    private final ReviewMapper reviewMapper;

    @Transactional
    @Override
    public void saveReview(Long wineId, CreateReviewRequestDto requestDto) {
        User currentUser = authenticatedUserService.getCurrentUser();
        Wine wine = wineRepository
                .findById(wineId)
                .orElseThrow(() -> new WineNotFoundException(wineId));

        if (reviewRepository.findByUserAndWine(currentUser, wine).isPresent()) {
            throw new ReviewAlreadyExistsException();
        }

        Review review = new Review();
        LocalDateTime now = LocalDateTime.now();

        review.setUser(currentUser);
        review.setWine(wine);
        review.setCreatedAt(now);

        review.setRating(requestDto.rating());
        review.setReviewText(requestDto.reviewText());
        review.setUpdatedAt(now);

        reviewRepository.save(review);
        updateWineRating(wine);
    }

    @Override
    public List<ReviewResponseDto> getWineReviews(Long wineId) {
        Wine wine = wineRepository
                .findById(wineId)
                .orElseThrow(() -> new WineNotFoundException(wineId));

        List<Review> reviews = reviewRepository
                .findAllByWineOrderByCreatedAtDesc(wine);

        return reviewMapper.toDtoList(reviews);
    }

    @Override
    public List<UserReviewResponseDto> getCurrentUserReviews() {
        User currentUser = authenticatedUserService.getCurrentUser();
        List<Review> reviews = reviewRepository
                .findAllByUserOrderByCreatedAtDesc(currentUser);

        return reviewMapper.toUserReviewDtoList(reviews);
    }

    @Transactional
    @Override
    public void updateReview(Long reviewId, CreateReviewRequestDto requestDto) {
        User currentUser = authenticatedUserService.getCurrentUser();

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(reviewId));

        if (!review.getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException(
                    "You cannot edit someone else's review"
            );
        }
        review.setRating(requestDto.rating());
        review.setReviewText(requestDto.reviewText());
        review.setUpdatedAt(LocalDateTime.now());

        reviewRepository.save(review);

        updateWineRating(review.getWine());
    }

    @Transactional
    @Override
    public void deleteReview(Long reviewId) {
        User currentUser = authenticatedUserService.getCurrentUser();

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException(reviewId));

        if (!review.getUser().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException(
                    "You cannot delete someone else's review"
            );
        }

        Wine wine = review.getWine();

        reviewRepository.delete(review);

        updateWineRating(wine);
    }

    private void updateWineRating(Wine wine) {
        BigDecimal averageRating = reviewRepository.findAverageRatingByWine(wine);

        averageRating = averageRating == null
                ? BigDecimal.ZERO
                : averageRating.setScale(2, RoundingMode.HALF_UP);

        wine.setRating(averageRating);
        wineRepository.save(wine);
    }
}
