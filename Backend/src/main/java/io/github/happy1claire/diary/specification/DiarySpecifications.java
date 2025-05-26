package io.github.happy1claire.diary.specification;

import io.github.happy1claire.diary.model.Diary;
import io.github.happy1claire.diary.model.Mood;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaQuery;
import java.time.LocalDateTime;

/**
 * This class is used to define specifications for querying diary entries.
 */
public class DiarySpecifications {

    /**
     * Creates a Specification that checks if the diary title contains the given keyword.
     *
     * @param keyword the text to search for in the title (case-sensitive).
     * @return a Specification that filters diaries with titles containing the keyword.
     */
    public static Specification<Diary> titleContains(String keyword) {
        return (Root<Diary> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
                cb.like(root.get("title"), "%" + keyword + "%");
    }

    /**
     * Creates a Specification that checks if the diary content contains the given keyword.
     *
     * @param keyword the text to search for in the content (case-sensitive).
     * @return a Specification that filters diaries with content containing the keyword.
     */
    public static Specification<Diary> contentContains(String keyword) {
        return (Root<Diary> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
                cb.like(root.get("content"), "%" + keyword + "%");
    }

    /**
     * Creates a Specification that filters diaries with the given mood.
     *
     * @param mood the mood to filter by.
     * @return a Specification that checks if the diary has the given mood.
     */
    public static Specification<Diary> hasMood(Mood mood) {
        return (Root<Diary> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
                cb.equal(root.get("mood"), mood);
    }

    /**
     * Creates a Specification that filters diaries created within the given date range.
     *
     * @param start the start date-time (inclusive).
     * @param end the end date-time (inclusive).
     * @return a Specification that filters by createdAt between start and end.
     */
    public static Specification<Diary> hasCreatedAtBetween(LocalDateTime start, LocalDateTime end) {
        return (Root<Diary> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
                cb.between(root.get("createdAt"), start, end);
    }

    /**
     * Creates a Specification that filters diaries written by a specific user.
     *
     * @param userId the user ID to match.
     * @return a Specification that filters diaries by userId.
     */
    public static Specification<Diary> hasUserId(String userId) {
        return (Root<Diary> root, CriteriaQuery<?> query, CriteriaBuilder cb) ->
                cb.equal(root.get("userId"), userId);
    }
}
