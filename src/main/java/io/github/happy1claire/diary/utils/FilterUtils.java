package io.github.happy1claire.diary.utils;

import io.github.happy1claire.diary.dto.FilterRequest;
import io.github.happy1claire.diary.model.Diary;
import io.github.happy1claire.diary.specification.DiarySpecifications;
import org.springframework.data.jpa.domain.Specification;

public class FilterUtils {

    private FilterUtils() {
        // Private constructor to prevent instantiation
    }

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
