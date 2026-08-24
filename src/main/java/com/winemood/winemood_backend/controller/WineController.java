package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.constants.swagger.AuthSwaggerExamples;
import com.winemood.winemood_backend.constants.swagger.UserSwaggerExamples;
import com.winemood.winemood_backend.dto.request.CreateReviewRequestDto;
import com.winemood.winemood_backend.dto.request.WineFilterRequestDto;
import com.winemood.winemood_backend.dto.response.ApiResponseDto;
import com.winemood.winemood_backend.dto.response.ReviewResponseDto;
import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.dto.response.WineResponseDto;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.service.ReviewService;
import com.winemood.winemood_backend.service.WineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/wines")
@Tag(name = "Wines", description = "Endpoints for managing wine")
public class WineController {
    private final WineService wineService;
    private final ReviewService reviewService;

    @GetMapping
    @Operation(summary = "Get all wines", description = "Return all wines")
    @ApiResponse(
            responseCode = "200",
            description = "Wines successfully retrieved",
            content = @Content(schema = @Schema(implementation = WineCatalogResponseDto.class))
    )
    public List<WineCatalogResponseDto> getAllWines(
            @ParameterObject
            @PageableDefault(page = 0, size = 20, sort = "id")
            Pageable pageable
    ) {
        return wineService.getAllWines(pageable);
    }

    @GetMapping("/{id:\\d+}")
    @Operation(summary = "Get wine by Id", description = "Returns wine by its ID")
    @ApiResponse(
            responseCode = "200",
            description = "Wine found",
            content = @Content(schema = @Schema(implementation = WineResponseDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Wine not found"
    )
    public WineResponseDto getWineById(@PathVariable Long id) {
        return wineService.getWineById(id);
    }

    @GetMapping("/{id:\\d+}/recommendations")
    @Operation(summary = "Get recommendations", description = "Returns recommendations by type of wine")
    @ApiResponse(
            responseCode = "200",
            description = "Wine recommendations found",
            content = @Content(schema = @Schema(implementation = WineCatalogResponseDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Recommendations not found"
    )
    public List<WineCatalogResponseDto> getRecommendations(
            @PathVariable Long id
    ) {
        return wineService.getRecommendations(id);
    }

    @PostMapping("/filter")
    @Operation(
            summary = "Filter wines",
            description = """
                    Returns wines filtered by selected parameters.
                                    
                    You can combine multiple filters:
                    - wine type
                    - sweetness level
                    - country
                    - grape variety
                    - wine style
                    - acidity
                    - aroma notes
                    - moods
                    - food pairing
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "Filtered wines successfully retrieved",
            content = @Content(
                    schema = @Schema(implementation = WineCatalogResponseDto.class)
            )
    )
    public ApiResponseDto<List<WineCatalogResponseDto>> filterWines(
            @RequestBody WineFilterRequestDto filterRequest,
            Pageable pageable
    ) {
        return wineService.filterWines(filterRequest, pageable);
    }

    @Operation(
            summary = "Create review",
            description = """
                    Creates a new review for the specified wine.
                                    
                    If the authenticated user has already reviewed this wine,
                    409 exception.
                    """
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Review saved successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Validation failed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = AuthSwaggerExamples.ERROR_400_VALIDATION
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authentication required",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = UserSwaggerExamples.ERROR_403_ACCESS_DENIED
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Wine not found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @PostMapping("/{wineId}/reviews")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveReview(
            @PathVariable Long wineId,
            @Valid @RequestBody CreateReviewRequestDto requestDto
    ) {
        reviewService.saveReview(wineId, requestDto);
    }

    @Operation(
            summary = "Get wine reviews",
            description = """
                    Returns all reviews for the specified wine ordered
                    from newest to oldest.
                    """
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Wine reviews returned successfully",
                    content = @Content(
                            schema = @Schema(implementation = ReviewResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Wine not found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @GetMapping("/{wineId}/reviews")
    public List<ReviewResponseDto> getWineReviews(
            @PathVariable Long wineId
    ) {
        return reviewService.getWineReviews(wineId);
    }
}
