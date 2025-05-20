package io.github.happy1claire.diary.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing sortable fields for the Diary entity.
 */
public enum SortField {
    /** Sort by title. */
    TITLE("title"),
    /** Sort by created date. */
    CREATED_AT("createdAt"),
    /** Sort by mood in lexicographical (alphabetical) order. */
    MOOD("mood"),
    /** Sort by updated date. */
    UPDATED_AT("updatedAt");

    /** The field name used in the database. */
    private final String fieldName;

    /**
     * Constructor to initialize the enum with the database field name.
     *
     * @param fieldName the name of the field in the database
     */
    SortField(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Returns the field name used in the database.
     * @return the field name
     */
    @JsonValue
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Returns the enum constant corresponding to the given string.
     * @param input the string representation of the enum
     * @return the corresponding enum constant
     * @throws IllegalArgumentException if the input does not match any enum constant
     */
    @JsonCreator
    public static SortField fromValue(String input) {
        for (SortField field : SortField.values()) {
            if (field.name().equalsIgnoreCase(input) || field.fieldName.equalsIgnoreCase(input)) {
                return field;
            }
        }
        throw new IllegalArgumentException("Unknown sort field: " + input);
    }

}
