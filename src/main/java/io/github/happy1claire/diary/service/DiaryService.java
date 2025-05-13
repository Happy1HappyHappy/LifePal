package io.github.happy1claire.diary.service;

import io.github.happy1claire.diary.dto.DiaryFilterRequest;
import io.github.happy1claire.diary.model.Diary;
import io.github.happy1claire.diary.repository.DiaryRepository;
import io.github.happy1claire.diary.specification.DiarySpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DiaryService {

    private final DiaryRepository diaryRepository;

    /**
     * Constructor for DiaryService.
     */
    @Autowired
    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    /**
     * Method to save a diary entry.
     * @param diary the diary to be added into database.
     */
    public void addNewDairy(Diary diary) throws Exception {
        if (diary ==null) {
            throw new IllegalArgumentException("Diary is null");
        }
        diaryRepository.save(diary);
    }

    /**
     * Method to search diary entries based on various criteria.
     * @param request the filter request DTO
     * @return the filtered list of diary entries
     */
    public List<Diary> searchDiaries(DiaryFilterRequest request) {
        Specification<Diary> spec = Specification.where(null);

        if (request == null) {
            throw new IllegalArgumentException("request is null");
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

        return diaryRepository.findAll(spec);
    }

}
