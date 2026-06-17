package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.SeasonResponseDto;
import com.winemood.winemood_backend.entity.Season;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    SeasonResponseDto toDto(Season season);
}
