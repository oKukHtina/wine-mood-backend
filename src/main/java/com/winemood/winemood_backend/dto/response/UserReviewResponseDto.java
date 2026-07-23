package com.winemood.winemood_backend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Review created by the authenticated user")
public record UserReviewResponseDto(

        @Schema(
                description = "Review identifier",
                example = "15"
        )
        Long reviewId,

        @Schema(
                description = "Wine identifier",
                example = "24"
        )
        Long wineId,

        @Schema(
                description = "Wine name",
                example = "Merlot Reserve"
        )
        String wineName,

        @Schema(
                description = "Wine image URL",
                example = "https://example.com/images/merlot.jpg"
        )
        String wineImageUrl,

        @Schema(
                description = "Rating given by the user",
                example = "4.75"
        )
        BigDecimal rating,

        @Schema(
                description = "User review text",
                example = "Very smooth wine with rich berry aroma."
        )
        String reviewText,

        @Schema(
                description = "Review creation date and time",
                example = "2026-07-24T18:30:15"
        )
        LocalDateTime createdAt
) {
}
