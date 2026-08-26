package com.winemood.winemood_backend.dto.response.asset;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryTimelineResponseDto {
    private String id;
    private String imageUrl;
    private String text;
}
