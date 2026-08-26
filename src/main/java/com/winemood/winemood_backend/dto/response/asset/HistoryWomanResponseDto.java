package com.winemood.winemood_backend.dto.response.asset;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryWomanResponseDto {
    @JsonProperty("default")
    private String defaultImage;
    private String cozy;
    private String dateNight;
    private String culinary;
    private String celebration;
}
