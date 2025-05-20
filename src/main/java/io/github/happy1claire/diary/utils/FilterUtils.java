package io.github.happy1claire.diary.utils;

import io.github.happy1claire.diary.dto.FilterRequest;
import io.github.happy1claire.diary.model.Diary;
import io.github.happy1claire.diary.specification.DiarySpecifications;
import org.springframework.data.jpa.domain.Specification;

/**
 * Utility class for creating JPA specifications for filtering diary entries.
 * It transfers a filter request(DTO class) into a JPA specification.
 * This class provides a static method to create a specification based on the provided filter request.
 */
public class FilterUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private FilterUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Creates a JPA specification based on the provided filter request.
     * @param request the filter request containing the criteria for filtering diary entries.
     * @return a JPA specification that can be used to filter diary entries.
     */
    public static Specification<Diary> makeFilter(FilterRequest request) {
        Specification<Diary> spec = Specification.where(null);

        if (request == null) {
            throw new IllegalArgumentException("Search request is null");
        }

        if (request.getTitle() != null) {
            spec = spec.and(DiarySpecifications.titleContains(request.getTitle()));
        }
        if (request.getContent() != null) {
            spec = spec.and(DiarySpecifications.contentContains(request.getContent()));
        }
        if (request.getMood() != null) {
            spec = spec.and(DiarySpecifications.hasMood(request.getMood()));
        }
        if (request.getStartDate() != null && request.getEndDate() != null) {
            spec = spec.and(DiarySpecifications.hasCreatedAtBetween(request.getStartDate(), request.getEndDate()));
        }
        if (request.getUserId() != null) {
            spec = spec.and(DiarySpecifications.hasUserId(request.getUserId()));
        }

        return spec;
    }

}
