package com.winemood.winemood_backend.dto.response.asset;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiteAssetsResponseDto {
    private SiteAssetSectionResponseDto home;
    private SiteAssetSectionResponseDto shared;
    private SiteAssetSectionResponseDto auth;
    private SiteAssetSectionResponseDto about;
    private SiteAssetSectionResponseDto reviews;
    private SiteAssetSectionResponseDto history;
}
