package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.AromaNoteResponseDto;
import com.winemood.winemood_backend.entity.AromaNote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AromaNoteMapper {
    AromaNoteResponseDto toDto(AromaNote aromaNote);

    default String map(AromaNote aromaNote) {
        return aromaNote.getName();
    }
}
