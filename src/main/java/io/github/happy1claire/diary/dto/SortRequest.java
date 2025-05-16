package io.github.happy1claire.diary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.domain.Sort;

/**
 * DTO class to encapsulate sorting information.
 */
public class SortRequest {

    @NotBlank(message = "sortBy field is required")
    private String sortBy;

    private String sortDirection;

    public SortRequest() {}

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    /**
     * Converts this DTO to a Spring Sort object.
     *
     * @param defaultSort fallback sort if this DTO is invalid
     * @return Sort object
     */
    public Sort toSpringSort(Sort defaultSort) {
        if (sortBy != null && sortDirection != null) {
            try {
                return Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
            } catch (IllegalArgumentException e) {
                // Invalid sort direction provided
            }
        }
        return defaultSort;
    }
}
