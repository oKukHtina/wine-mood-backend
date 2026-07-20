package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.constants.swagger.UserSwaggerExamples;
import com.winemood.winemood_backend.dto.response.FavoriteWineResponseDto;
import com.winemood.winemood_backend.dto.response.UserResponseDto;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
@Tag(
        name = "User profile",
        description = "Endpoints for managing the authenticated user's profile"
)
public class UserController {

    private final UserService userService;

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
}