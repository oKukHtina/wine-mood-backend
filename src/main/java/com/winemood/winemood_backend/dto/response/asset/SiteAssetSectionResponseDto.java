package com.winemood.winemood_backend.dto.response.asset;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SiteAssetSectionResponseDto {
    private String heroBackgroundUrl;
    private String pagePatternUrl;
    private String backgroundUrl;
    private String bottleImageUrl;
    private String wineBackdropUrl;
    private String videoUrl;
}
