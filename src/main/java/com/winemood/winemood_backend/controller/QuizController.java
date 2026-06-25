package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.request.QuizRequestDto;
import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.service.QuizService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quiz")
@Tag(name = "Quiz", description = "Endpoints for managing result of quiz")
public class QuizController {
    private final QuizService quizService;

    @PostMapping("/result")
    @Operation(summary = "Get quiz result", description = "Returns a list of quiz result")
    @ApiResponse(responseCode = "200", description = "Result successfully retrieved")
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    public List<WineCatalogResponseDto> getResult(@RequestBody QuizRequestDto request) {
        return quizService.calculateResult(request);
    }
}
