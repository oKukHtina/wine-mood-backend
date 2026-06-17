package com.winemood.winemood_backend.entity;

import com.winemood.winemood_backend.enums.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "wine_taste_profiles")
public class WineTasteProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wine_id", nullable = false, unique = true)
    private Wine wine;

    @ManyToOne
    @JoinColumn(name = "grape_variety_id")
    private GrapeVariety grapeVariety;

    private Integer agingMonths;

    private String fermentationType;

    @Column(length = 100)
    private String appellation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acidity_id")
    private Acidity acidity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "wine_aroma_notes",
            joinColumns = @JoinColumn(name = "wine_taste_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "aroma_note_id")
    )
    private Set<AromaNote> aromaNotes = new HashSet<>();

    @ElementCollection(targetClass = EnvironmentalAttribute.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "wine_environmental_attributes",
            joinColumns = @JoinColumn(name = "wine_taste_profile_id")
    )
    @Column(name = "environmental_attribute")
    private Set<EnvironmentalAttribute> environmentalAttributes = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sweetness_id")
    private SweetnessLevel sweetnessLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wine_style_id")
    private WineStyle wineStyle;
}
