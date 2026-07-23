package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.request.CreateReviewRequestDto;
import com.winemood.winemood_backend.dto.response.ReviewResponseDto;
import com.winemood.winemood_backend.dto.response.UserReviewResponseDto;

import java.util.List;

public interface ReviewService {

    void saveReview(Long wineId, CreateReviewRequestDto requestDto);

    List<ReviewResponseDto> getWineReviews(Long wineId);

    List<UserReviewResponseDto> getCurrentUserReviews();
}
