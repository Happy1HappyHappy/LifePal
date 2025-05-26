package io.github.happy1claire.diary.dto;

import io.github.happy1claire.diary.model.SortField;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Sort;

/**
 * DTO class to encapsulate sorting information.
 */
public class SortRequest {

    /**
     * The field by which to sort the diary entries.
     */
    @NotBlank(message = "sortBy field is required")
    private SortField sortBy;

    /**
     * The direction of the sort.
     * It only accepts "asc" or "desc" (case-insensitive).
     */
    private String sortDirection;

    /**
     * Default constructor.
     */
    public SortRequest() {
        // Default constructor, conform with DTO pattern.
    }

    /**
     * Returns the field by which to sort.
     *
     * @return the sorting field
     */
    public SortField getSortBy() {
        return sortBy;
    }

    /**
     * Sets the field by which to sort.
     *
     * @param sortBy the sorting field
     */
    public void setSortBy(SortField sortBy) {
        this.sortBy = sortBy;
    }

    /**
     * Returns the direction of the sort.
     *
     * @return the sorting direction
     */
    public String getSortDirection() {
        return sortDirection;
    }

    /**
     * Sets the direction of the sort.
     *
     * @param sortDirection the sorting direction
     */
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
                return Sort.by(Sort.Direction.fromString(sortDirection), sortBy.getFieldName());
            } catch (IllegalArgumentException e) {
                // Invalid sort direction provided
            }
        }
        return defaultSort;
    }
}
