package com.winemood.winemood_backend.dto.response;

import com.winemood.winemood_backend.enums.FilterKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterMetadataResponseDto {
    private FilterKey filterKey;
    private String title;
    private String iconUrl;
    private Object options;
}
