package com.winemood.winemood_backend.entity;

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

    @Column(name = "vintage")
    private Integer vintage;


    @Column(nullable = false)
    private Double rating = 0.0;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "wine_events",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private Set<Event> events = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "wine_seasons",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "season_id")
    )
    private Set<Season> seasons = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "wine_food_pairing",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private Set<Food> foodPairings = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "wine_moods",
            joinColumns = @JoinColumn(name = "wine_id"),
            inverseJoinColumns = @JoinColumn(name = "mood_id")
    )
    private Set<Mood> moods = new HashSet<>();

    @OneToOne(mappedBy = "wine", cascade = CascadeType.ALL)
    private WineTasteProfile tasteProfile;

    @ManyToOne
    private PriceLevel priceLevel;

    @ManyToOne
    private AgingPotential agingPotential;
}
