package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.EventResponseDto;
import com.winemood.winemood_backend.entity.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventResponseDto toDto(Event event);
}
