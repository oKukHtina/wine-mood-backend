package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.EventResponseDto;
import com.winemood.winemood_backend.exceptions.ErrorResponse;
import com.winemood.winemood_backend.service.EventService;
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
@RequestMapping("/api/event")
@Tag(name = "Event", description = "Endpoints for managing wine events")
public class EventController {
    private final EventService service;

    @Operation(summary = "Get events", description = "Returns a list of all wine events")
    @ApiResponse(responseCode = "200", description = "Events successfully retrieved")
    @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
    )
    @GetMapping
    public List<EventResponseDto> getAllEvents() {
        return service.getAllEvents();
    }
}
