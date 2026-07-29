package com.winemood.winemood_backend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User information")
public class UserResponseDto {
    @Schema(
            description = "Unique user identifier",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "User display name",
            example = "Bob"
    )
    private String name;

    @Schema(
            description = "User email address",
            example = "bob@example.com"
    )
    private String email;

    @Schema(
            description = "URL of the user's avatar image. Returns null if the user has not uploaded an avatar.",
            example = "https://res.cloudinary.com/demo/image/upload/v1234567890/avatar.jpg",
            nullable = true
    )
    private String avatarUrl;

    @Schema(
            description = "Total number of reviews created by the user",
            example = "12"
    )
    private long reviewCount;
}
