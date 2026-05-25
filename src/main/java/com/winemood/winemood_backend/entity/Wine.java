package com.winemood.winemood_backend.entity;

import com.winemood.winemood_backend.enums.EnvironmentalAttribute;
import com.winemood.winemood_backend.enums.GrapeVariety;
import com.winemood.winemood_backend.enums.SweetnessLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "wines")
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    private Integer volumeMl;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @NotBlank
    @Column(nullable = false)
    private String imageUrl;

    @Column(precision = 4, scale = 1)
    private BigDecimal alcoholPercentage;

    @Enumerated(EnumType.STRING)
    private SweetnessLevel sweetnessLevel;

    @Enumerated(EnumType.STRING)
    private GrapeVariety grapeVariety;

    private Integer agingMonths;

    @ElementCollection(targetClass = EnvironmentalAttribute.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "wine_environmental_attributes",
            joinColumns = @JoinColumn(name = "wine_id")
    )
    @Column(name = "environmental_attribute")
    private Set<EnvironmentalAttribute> environmentalAttributes;

    private String fermentationType;

    @Column(name = "vintage")
    private Integer vintage;

    @Column(length = 100)
    private String appellation;
}
