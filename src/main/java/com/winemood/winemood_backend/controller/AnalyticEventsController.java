package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.request.AnalyticsEventRequestDto;
import com.winemood.winemood_backend.service.AnalyticsEventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
@Tag(
        name = "Analytics",
        description = "Endpoints for collecting user analytics events"
)
public class AnalyticEventsController {
    private final AnalyticsEventService analyticsEventService;

    @Operation(
            summary = "Save analytics event",
            description = """
                    Saves a user analytics event.
                                        
                    The backend automatically adds:
                    - user_id — authenticated user, if available
                    - created_at — event creation time
                                        
                    Frontend should NOT send timestamp or user_id.
                                        
                    Supported events:                   
                    SEARCH_STARTED:
                    {"search_type":"catalog","query":"Verde"}
                                        
                    PAGE_VIEWED:
                    {"page_url":"/wines/37"}
                                        
                    SESSION_STARTED:
                    {"session_id":"abc123","device_type":"mobile"}
                    """
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Analytics event successfully saved"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid analytics event"
            )
    })
    @PostMapping("/events")
    public ResponseEntity<Void> saveEvent(
            @RequestBody AnalyticsEventRequestDto request
    ) {
        analyticsEventService.saveEvent(
                request.getEventType(),
                request.getEventData()
        );

        return ResponseEntity.ok().build();
    }
}
