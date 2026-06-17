package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.AromaNoteResponseDto;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.service.AromaNoteService;
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
@RequestMapping("/api/aromaNote")
@Tag(name = "Aroma_Note", description = "Endpoints for managing wine aroma note")
public class AromaNoteController {

    private final AromaNoteService service;

    @Operation(summary = "Get all aroma note", description = "Returns a list of all aroma note")
    @ApiResponse(responseCode = "200", description = "Aroma note successfully retrieved")
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    @GetMapping
    public List<AromaNoteResponseDto> getAllAcidity() {
        return service.getAllAromaNote();
    }

}
