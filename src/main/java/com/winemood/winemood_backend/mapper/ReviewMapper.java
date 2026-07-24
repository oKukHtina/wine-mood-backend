package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.ReviewResponseDto;
import com.winemood.winemood_backend.dto.response.UserReviewResponseDto;
import com.winemood.winemood_backend.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "user.avatarUrl", target = "avatarUrl")
    @Mapping(source = "user.id", target = "userId")
    ReviewResponseDto toDto(Review review);

    @Mapping(source = "id", target = "reviewId")
    @Mapping(source = "wine.id", target = "wineId")
    @Mapping(source = "wine.name", target = "wineName")
    @Mapping(source = "wine.imageUrl", target = "wineImageUrl")
    UserReviewResponseDto toUserReviewDto(Review review);

    List<ReviewResponseDto> toDtoList(List<Review> reviews);

    List<UserReviewResponseDto> toUserReviewDtoList(List<Review> reviews);
}
