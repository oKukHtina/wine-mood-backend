package com.winemood.winemood_backend.entity;

import com.winemood.winemood_backend.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.HashSet;
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
    private Set<EnvironmentalAttribute> environmentalAttributes = new HashSet<>();;

    private String fermentationType;

    @Column(name = "vintage")
    private Integer vintage;

    @Column(length = 100)
    private String appellation;

    @Column(nullable = false)
    private Double rating = 0.0;

    @Enumerated(EnumType.STRING)
    private Acidity acidity;

    @ElementCollection(targetClass = AromaNote.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "wine_aroma_notes",
            joinColumns = @JoinColumn(name = "wine_id")
    )
    @Column(name = "aroma_note")
    private Set<AromaNote> aromaNotes = new HashSet<>();

    @ElementCollection(targetClass = Mood.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "wine_moods",
            joinColumns = @JoinColumn(name = "wine_id")
    )
    @Column(name = "mood")
    private Set<Mood> moods = new HashSet<>();

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "wine_events",
            joinColumns = @JoinColumn(name = "wine_id")
    )
    @Column(name = "event")
    private Set<Event> events = new HashSet<>();

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "wine_seasons",
            joinColumns = @JoinColumn(name = "wine_id")
    )
    @Column(name = "season")
    private Set<Season> seasons = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private WineStyle wineStyle;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "wine_food_pairing",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private Set<Food> foodPairings = new HashSet<>();

}
