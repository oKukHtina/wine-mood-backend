package com.winemood.winemood_backend.dto.response.asset;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryOriginResponseDto {
    private String id;
    private String title;
    private String description;
    private String imageUrl;
}
