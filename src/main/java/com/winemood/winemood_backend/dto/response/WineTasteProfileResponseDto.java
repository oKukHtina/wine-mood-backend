package com.winemood.winemood_backend.dto.response;

import com.winemood.winemood_backend.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WineTasteProfileResponseDto {
    private Long id;
    private Integer agingMonths;
    private String fermentationType;
    private String appellation;
    private AcidityResponseDto acidity;
    private SweetnessLevelResponseDto sweetnessLevel;
    private WineStyleResponseDto wineStyle;
    private Set<AromaNoteResponseDto> aromaNotes;
    private Set<EnvironmentalAttribute> environmentalAttributes;
    private GrapeVarietiesResponseDto grapeVariety;
}
