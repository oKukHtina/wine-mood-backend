package com.winemood.winemood_backend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request for user login")
public class UserLoginRequestDto {
    @NotBlank
    @Email
    @Schema(
            description = "User email address",
            example = "john.doe@example.com"
    )
    private String email;

    @NotBlank
    @Schema(
            description = "User password",
            example = "Password123"
    )
    private String password;
}
