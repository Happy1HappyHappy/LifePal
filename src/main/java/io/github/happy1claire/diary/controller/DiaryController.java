package io.github.happy1claire.diary.controller;

import io.github.happy1claire.diary.model.Diary;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * REST controller for managing diary entries.
 */
public class DiaryController {

    public DiaryController() {}

    @GetMapping("/api/diary")
    public List<Diary> getAllDiaries() {
        return diaryRepository.findAll();
    }
}
