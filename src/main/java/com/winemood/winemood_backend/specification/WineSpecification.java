package com.winemood.winemood_backend.specification;

import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.*;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

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

    public static Specification<Wine> hasSweetnessLevels(Set<String> names){
        return (root, query, cb) -> {

            if (names == null || names.isEmpty()) {
                return null;
            }

            return root.get("tasteProfile")
                    .get("sweetnessLevel")
                    .get("name")
                    .in(names);
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

    public static Specification<Wine> hasGrapeVarieties(Set<String> names) {
        return (root, query, cb) -> {

            if (names == null || names.isEmpty()) {
                return null;
            }

            return root.get("tasteProfile")
                    .get("grapeVariety")
                    .get("name")
                    .in(names);
        };
    }

    public static Specification<Wine> hasWineStyles(Set<String> wineStyles) {
        return (root, query, cb) -> {

            if (wineStyles == null || wineStyles.isEmpty()) {
                return null;
            }

            return root.get("tasteProfile")
                    .get("wineStyle")
                    .get("name")
                    .in(wineStyles);
        };
    }

    public static Specification<Wine> hasAcidityLevels(Set<String> names) {
        return (root, query, cb) -> {

            if (names == null || names.isEmpty()) {
                return null;
            }

            return root.get("tasteProfile")
                    .get("acidity")
                    .get("name")
                    .in(names);
        };
    }

    public static Specification<Wine> hasAromaNotes(Set<String> names) {
        return (root, query, cb) -> {

            if (names == null || names.isEmpty()) {
                return null;
            }

            query.distinct(true);

            Join<Object, Object> join = root
                    .join("tasteProfile")
                    .join("aromaNotes");

            return join.get("name").in(names);
        };
    }

    public static Specification<Wine> hasMoods(Set<String> moods) {
        return (root, query, cb) -> {

            if (moods == null || moods.isEmpty()) {
                return null;
            }

            query.distinct(true);

            Join<Object, Object> join = root.join("moods", JoinType.LEFT);

            return join.get("name").in(moods);
        };
    }

    public static Specification<Wine> hasEvents(Set<String> events) {
        return (root, query, cb) -> {

            if (events == null || events.isEmpty()) {
                return null;
            }

            query.distinct(true);

            Join<Object, Object> join = root.join("events", JoinType.LEFT);

            return join.get("name").in(events);
        };
    }

    public static Specification<Wine> hasSeasons(Set<String> seasons) {
        return (root, query, cb) -> {

            if (seasons == null || seasons.isEmpty()) {
                return null;
            }

            query.distinct(true);

            Join<Object, Object> join = root.join("seasons", JoinType.LEFT);

            return join.get("name").in(seasons);
        };
    }

    public static Specification<Wine> hasFoods(Set<String> foodNames) {

        return (root, query, cb) -> {

            if (foodNames == null || foodNames.isEmpty()) {
                return null;
            }

            query.distinct(true);

            return root
                    .join("foodPairings", JoinType.LEFT)
                    .get("name")
                    .in(foodNames);
        };
    }
}