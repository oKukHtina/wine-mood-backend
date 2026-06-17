package com.winemood.winemood_backend.entity;

import com.winemood.winemood_backend.enums.FilterKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "filter_metadata")
public class FilterMetadata {
    @Id
    @Enumerated(EnumType.STRING)
    private FilterKey filterKey;

    private String title;

    private String iconUrl;
}
