package com.winemood.winemood_backend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Schema(description = "Review creation request")
public record CreateReviewRequestDto(

        @Schema(
                description = "Rating from 1.00 to 5.00",
                example = "4.75"
        )
        @NotNull
        @DecimalMin("1.00")
        @DecimalMax("5.00")
        @Digits(integer = 1, fraction = 2)
        BigDecimal rating,

        @Schema(
                description = "Review text",
                example = "Very smooth wine with a rich berry aroma."
        )
        @NotBlank
        String reviewText
) {
}
