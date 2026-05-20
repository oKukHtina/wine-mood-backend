package com.winemood.winemood_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "producers")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @NotBlank
    @Column(nullable = false)
    private String region;

    @NotBlank
    @Column(nullable = false)
    private String bottleImageUrl;
}
