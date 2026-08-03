package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.constants.swagger.UserSwaggerExamples;
import com.winemood.winemood_backend.dto.request.CreateReviewRequestDto;
import com.winemood.winemood_backend.dto.request.SaveQuizResultRequestDto;
import com.winemood.winemood_backend.dto.response.*;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.service.AchievementService;
import com.winemood.winemood_backend.service.QuizResultService;
import com.winemood.winemood_backend.service.ReviewService;
import com.winemood.winemood_backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
@Tag(
        name = "User profile",
        description = "Endpoints for managing the authenticated user's profile"
)
public class UserController {

    private final UserService userService;
    private final QuizResultService quizResultService;
    private final ReviewService reviewService;

    private final AchievementService achievementService;

    @Operation(
            summary = "Upload user avatar",
            description = "Uploads a new avatar or replaces the current avatar of the authenticated user."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Avatar uploaded successfully",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid image file",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Empty file",
                                            value = UserSwaggerExamples.ERROR_400_IMAGE_IS_EMPTY
                                    ),
                                    @ExampleObject(
                                            name = "Unsupported image type",
                                            value = UserSwaggerExamples.ERROR_400_UNSUPPORTED_IMAGE_TYPE
                                    ),
                                    @ExampleObject(
                                            name = "Image too large",
                                            value = UserSwaggerExamples.ERROR_400_IMAGE_TOO_LARGE
                                    )
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authentication required",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = UserSwaggerExamples.ERROR_403_ACCESS_DENIED
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Image upload failed",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = UserSwaggerExamples.ERROR_500_IMAGE_UPLOAD_FAILED
                            )
                    )
            )
    })
    @PutMapping(
            value = "/avatar",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public UserResponseDto uploadAvatar(
            @RequestParam("image") MultipartFile image
    ) {
        return userService.uploadAvatar(image);
    }

    @Operation(
            summary = "Delete user avatar",
            description = "Deletes the current avatar of the authenticated user."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Avatar deleted successfully",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authentication required",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = UserSwaggerExamples.ERROR_403_ACCESS_DENIED
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Image deletion failed",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = UserSwaggerExamples.ERROR_500_IMAGE_DELETE_FAILED
                            )
                    )
            )
    })
    @DeleteMapping("/avatar")
    public UserResponseDto deleteAvatar() {
        return userService.deleteAvatar();
    }

    @Operation(
            summary = "Add wine to favorites",
            description = "Adds a wine to the authenticated user's favorites."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Wine added to favorites successfully"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authentication required",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
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
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @PostMapping("/favorites/{wineId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addFavorite(@PathVariable Long wineId) {
        userService.addFavorite(wineId);
    }

    @Operation(
            summary = "Remove wine from favorites",
            description = "Removes a wine from the authenticated user's favorites."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Wine removed from favorites successfully"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authentication required",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
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
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    @DeleteMapping("/favorites/{wineId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeFavorite(@PathVariable Long wineId) {
        userService.removeFavorite(wineId);
    }

    @Operation(
            summary = "Get favorite wines",
            description = "Returns all wines added to favorites by the authenticated user."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Favorite wines returned successfully",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = FavoriteWineResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authentication required",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = UserSwaggerExamples.ERROR_403_ACCESS_DENIED
                            )
                    )
            )
    })
    @GetMapping("/favorites")
    public FavoriteWineResponseDto getFavoriteWines() {
        return userService.getFavoriteWines();
    }

    @Operation(
            summary = "Get current user",
            description = "Returns the profile of the authenticated user."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "User profile returned successfully",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UserResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authentication required",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = UserSwaggerExamples.ERROR_403_ACCESS_DENIED
                            )
                    )
            )
    })
    @GetMapping("/me")
    public UserResponseDto currentUser() {
        return userService.getCurrentUser();
    }

    @Operation(
            summary = "Get quiz history",
            description = "Returns all quiz results of the authenticated user ordered from newest to oldest."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Quiz history returned successfully",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = QuizResultResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authentication required",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = UserSwaggerExamples.ERROR_403_ACCESS_DENIED
                            )
                    )
            )
    })
    @GetMapping("/quiz-history")
    public List<QuizResultResponseDto> getQuizHistory() {
        return quizResultService.getQuizHistory();
    }

    @Operation(
            summary = "Save quiz result",
            description = "Saves the latest quiz result for the authenticated user. "
                    + "If the user is not authenticated, the request is ignored."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Quiz result saved successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request body",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Authentication required",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = UserSwaggerExamples.ERROR_403_ACCESS_DENIED
                            )
                    )
            )
    })
    @PostMapping("/quiz-history")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveQuizHistory(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Quiz result to save",
                    required = true
            )
            @RequestBody SaveQuizResultRequestDto request
    ) {
        quizResultService.saveQuizResult(request.wineIds());
    }

    @Operation(
            summary = "Get current user reviews",
            description = "Returns all reviews created by the authenticated user ordered from newest to oldest."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "User reviews returned successfully",
                    content = @Content(
                            schema = @Schema(implementation = UserReviewResponseDto.class)
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
            )
    })
    @GetMapping("/reviews")
    public List<UserReviewResponseDto> getCurrentUserReviews() {
        return reviewService.getCurrentUserReviews();
    }

    @PutMapping("/reviews/{reviewId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Update current user's review",
            description = "Updates an existing review created by the authenticated user."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Review successfully updated"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Validation failed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "You cannot edit someone else's review",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Review not found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    public void updateReview(
            @PathVariable Long reviewId,
            @Valid @RequestBody CreateReviewRequestDto requestDto
    ) {
        reviewService.updateReview(reviewId, requestDto);
    }

    @DeleteMapping("/reviews/{reviewId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete current user's review",
            description = "Deletes a review created by the authenticated user."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Review successfully deleted"
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "You cannot delete someone else's review",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Review not found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    public void deleteReview(
            @PathVariable Long reviewId
    ) {
        reviewService.deleteReview(reviewId);
    }

    @GetMapping("/me/achievements")
    @Operation(
            summary = "Get current user's achievements",
            description = "Returns all achievements unlocked by the authenticated user."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Achievements successfully returned"
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "User is not authenticated",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )
            )
    })
    public List<AchievementResponseDto> getCurrentUserAchievements() {
        return achievementService.getCurrentUserAchievements();
    }
}