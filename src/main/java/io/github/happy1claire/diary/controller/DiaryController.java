package io.github.happy1claire.diary.controller;

import io.github.happy1claire.diary.dto.DiaryFilterRequest;
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
    public ResponseEntity<List<Diary>> searchDiaries(@RequestBody DiaryFilterRequest filterRequest) {
        List<Diary> results = diaryService.searchDiaries(filterRequest);
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

}
