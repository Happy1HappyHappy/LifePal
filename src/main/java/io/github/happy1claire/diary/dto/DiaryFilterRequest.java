package io.github.happy1claire.diary.dto;

import io.github.happy1claire.diary.model.Mood;

import java.time.LocalDateTime;

public class DiaryFilterRequest {
    /**
     * Optional keyword to search within the diary title.
     */
    private String title;

    /**
     * Optional keyword to search within the diary content.
     */
    private String content;

    /**
     * Optional mood to filter diary entries by.
     */
    private Mood mood;

    /**
     * Optional start date for filtering entries based on creation time.
     */
    private LocalDateTime startDate;

    /**
     * Optional end date for filtering entries based on creation time.
     */
    private LocalDateTime endDate;

    /**
     * Optional user ID to restrict the search to diaries belonging to a specific user.
     */
    private String userId;

    /**
     * Returns the title keyword to search for.
     *
     * @return the title keyword, or null if not specified
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title keyword to search for.
     *
     * @param title the title keyword to search
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the content keyword to search for.
     *
     * @return the content keyword, or null if not specified
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content keyword to search for.
     *
     * @param content the content keyword to search
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Returns the mood to filter by.
     *
     * @return the mood, or null if not specified
     */
    public Mood getMood() {
        return mood;
    }

    /**
     * Sets the mood to filter by.
     *
     * @param mood the mood to match
     */
    public void setMood(Mood mood) {
        this.mood = mood;
    }

    /**
     * Returns the start of the createdAt range.
     *
     * @return the start date-time, or null if not specified
     */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /**
     * Sets the start of the createdAt range.
     *
     * @param startDate the start date-time (inclusive)
     */
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns the end of the createdAt range.
     *
     * @return the end date-time, or null if not specified
     */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    /**
     * Sets the end of the createdAt range.
     *
     * @param endDate the end date-time (inclusive)
     */
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * Returns the user ID to filter by.
     *
     * @return the user ID, or null if not specified
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user ID to filter by.
     *
     * @param userId the user ID to match
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
