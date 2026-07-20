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
public class FavoriteWineResponseDto {
    private int count;
    private List<WineCatalogResponseDto> wines;
}
