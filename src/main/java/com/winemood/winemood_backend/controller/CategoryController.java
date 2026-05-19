package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.CategoryUiResponse;
import com.winemood.winemood_backend.dto.ErrorResponse;
import com.winemood.winemood_backend.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
@Tag(name = "Categories", description = "Endpoints for managing wine categories")
public class CategoryController {
    private final CategoryService service;

    @Operation(summary = "Get all categories", description = "Returns a list of all wine categories")
    @ApiResponse(responseCode = "200", description = "Categories successfully retrieved")
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    @GetMapping
    public List<CategoryUiResponse> getAllCategories() {
        return service.getAllCategories();
    }
}
