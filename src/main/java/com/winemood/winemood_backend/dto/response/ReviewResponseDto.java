package com.winemood.winemood_backend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Wine review")
public record ReviewResponseDto(

        @Schema(
                description = "Review identifier",
                example = "15"
        )
        Long id,

        @Schema(
                description = "Reviewer name",
                example = "Bob"
        )
        String userName,

        @Schema(
                description = "Reviewer avatar URL",
                example = "https://example.com/avatars/user15.jpg"
        )
        String avatarUrl,

        @Schema(
                description = "Rating given by the user",
                example = "4.75"
        )
        BigDecimal rating,

        @Schema(
                description = "Review text",
                example = "Very smooth wine with a rich berry aroma."
        )
        String reviewText,

        @Schema(
                description = "Review creation date and time",
                example = "2026-07-24T18:30:15"
        )
        LocalDateTime createdAt
) {
}
