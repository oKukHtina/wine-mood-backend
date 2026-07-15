package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.constants.swagger.AuthSwaggerExamples;
import com.winemood.winemood_backend.dto.request.UserLoginRequestDto;
import com.winemood.winemood_backend.dto.request.UserRegistrationRequestDto;
import com.winemood.winemood_backend.dto.response.AuthenticationResponseDto;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.exceptions.RegistrationException;
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
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication", description = "Authentication endpoints")
public class AuthController {
    private final UserService userService;

    @Operation(
            summary = "Register a new user",
            description = "Creates a new user account with email, username and password."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "User successfully registered",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AuthenticationResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Validation failed",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = AuthSwaggerExamples.ERROR_400_VALIDATION
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "User with this email already exists",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = AuthSwaggerExamples.ERROR_409_USER_ALREADY_EXISTS
                            )
                    )
            )
    })
    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthenticationResponseDto registerUser(@Valid @RequestBody UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        return userService.register(requestDto);
    }

    @Operation(
            summary = "Login user",
            description = "Authenticates a user and returns a JWT token."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "User successfully authenticated",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AuthenticationResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Validation failed",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = AuthSwaggerExamples.ERROR_400_VALIDATION
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Invalid email or password",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject(
                                    value = AuthSwaggerExamples.ERROR_401_INVALID_CREDENTIALS
                            )
                    )
            )
    })
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponseDto login(@Valid @RequestBody UserLoginRequestDto requestDto) {
        return userService.login(requestDto);
    }
}
