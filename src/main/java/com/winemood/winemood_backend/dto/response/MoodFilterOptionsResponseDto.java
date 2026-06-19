package com.winemood.winemood_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoodFilterOptionsResponseDto {
    private List<MoodResponseDto> moods;
    private List<EventResponseDto> events;
    private List<SeasonResponseDto> seasons;
}
