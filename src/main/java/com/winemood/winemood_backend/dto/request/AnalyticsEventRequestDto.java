package com.winemood.winemood_backend.dto.request;

import com.winemood.winemood_backend.enums.AnalyticsEventType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Analytics event request")
public class AnalyticsEventRequestDto {
    @Schema(
            description = "Type of analytics event",
            example = "SEARCH_STARTED",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private AnalyticsEventType eventType;

    @Schema(
            description = """
                    Event-specific data.
                                        
                    SEARCH_STARTED:
                    {"search_type":"catalog","query":"Verde"}
                                        
                    PAGE_VIEWED:
                    {"page_url":"/wines/27"}
                                        
                    SESSION_STARTED:
                    {"session_id":"abc123","device_type":"mobile"}
                    """,
            example = "{\"search_type\":\"catalog\",\"query\":\"Verde\"}",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Map<String, Object> eventData;
}
