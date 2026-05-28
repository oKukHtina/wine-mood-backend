package com.winemood.winemood_backend.specification;

import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.*;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import java.util.Set;

public class WineSpecification {
    public static Specification<Wine> hasWineTypes(Set<CategoryType> wineTypes) {
        return (root, query, cb) -> {

            if (wineTypes == null || wineTypes.isEmpty()) {
                return null;
            }

            return root.get("category")
                    .get("type")
                    .in(wineTypes);
        };
    }

    public static Specification<Wine> hasSweetnessLevels(Set<SweetnessLevel> levels) {
        return (root, query, cb) -> {

            if (levels == null || levels.isEmpty()) {
                return null;
            }

            return root.get("sweetnessLevel").in(levels);
        };
    }

    public static Specification<Wine> hasCountries(Set<String> countries) {
        return (root, query, cb) -> {

            if (countries == null || countries.isEmpty()) {
                return null;
            }

            return root.get("producer")
                    .get("country")
                    .get("name")
                    .in(countries);
        };
    }

    public static Specification<Wine> hasGrapeVarieties(Set<GrapeVariety> varieties) {
        return (root, query, cb) -> {

            if (varieties == null || varieties.isEmpty()) {
                return null;
            }

            return root.get("grapeVariety").in(varieties);
        };
    }

    public static Specification<Wine> hasWineStyles(Set<WineStyle> styles) {
        return (root, query, cb) -> {

            if (styles == null || styles.isEmpty()) {
                return null;
            }

            return root.get("wineStyle").in(styles);
        };
    }

    public static Specification<Wine> hasAcidityLevels(Set<Acidity> levels) {
        return (root, query, cb) -> {

            if (levels == null || levels.isEmpty()) {
                return null;
            }

            return root.get("acidity").in(levels);
        };
    }

    public static Specification<Wine> hasAromaNotes(Set<AromaNote> notes) {
        return (root, query, cb) -> {

            if (notes == null || notes.isEmpty()) {
                return null;
            }

            query.distinct(true);

            Join<Object, Object> join = root.join("aromaNotes", JoinType.LEFT);

            return join.in(notes);
        };
    }

    public static Specification<Wine> hasMoods(Set<Mood> moods) {
        return (root, query, cb) -> {

            if (moods == null || moods.isEmpty()) {
                return null;
            }

            query.distinct(true);

            Join<Object, Object> join = root.join("moods", JoinType.LEFT);

            return join.in(moods);
        };
    }

    public static Specification<Wine> hasFoodTypes(Set<FoodType> foodTypes) {
        return (root, query, cb) -> {

            if (foodTypes == null || foodTypes.isEmpty()) {
                return null;
            }

            query.distinct(true);

            Join<Object, Object> join = root.join("foodPairings", JoinType.LEFT);

            return join.get("foodType").in(foodTypes);
        };
    }
}