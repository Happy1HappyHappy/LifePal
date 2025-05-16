package io.github.happy1claire.diary.model;

/**
 * Enum representing sortable fields for the Diary entity.
 */
public enum SortField {
    TITLE("title"),
    CREATED_AT("createdAt"),
    MOOD("mood"),
    UPDATED_AT("updatedAt");

    private final String fieldName;

    SortField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
