package io.github.happy1claire.diary.controller;

import io.github.happy1claire.diary.dto.FilterRequest;
import io.github.happy1claire.diary.dto.SortRequest;
import io.github.happy1claire.diary.model.Diary;
import io.github.happy1claire.diary.service.DiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing diary entries.
 */
@RestController
@RequestMapping("/api/diaries")
public class DiaryController {

    /**
     * Service for handling diary-related operations.
     */
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    /**
     * Searches diary entries using flexible filter criteria.
     *
     * @param filterRequest the filter request DTO
     * @return the filtered list of diary entries
     */
    @PostMapping("/search")
    public ResponseEntity<List<Diary>> searchDiaries(@RequestBody FilterRequest filterRequest, @RequestBody SortRequest sortRequest) {
        List<Diary> results = diaryService.searchDiaries(filterRequest, sortRequest);
        return ResponseEntity.ok(results);
    }

    /**
     * Saves a new diary entry.
     *
     * @param diary the diary entry to save
     * @return the saved diary entry
     */
    @PostMapping("/save")
    public ResponseEntity<Diary> saveDiary(@RequestBody Diary diary) {
        try {
            diaryService.addNewDairy(diary);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(diary);
    }

    /**
     * Deletes a diary entry by its ID.
     *
     * @param diaryId the ID of the diary entry to delete
     * @return a response indicating success or failure
     */
    @DeleteMapping("/delete/{diaryId}")
    public ResponseEntity<Void> deleteDiary(@PathVariable Long diaryId) {
        try {
            diaryService.deleteDiary(diaryId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
