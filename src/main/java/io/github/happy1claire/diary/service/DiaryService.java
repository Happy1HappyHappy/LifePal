package io.github.happy1claire.diary.service;

import io.github.happy1claire.diary.dto.FilterRequest;
import io.github.happy1claire.diary.dto.SortRequest;
import io.github.happy1claire.diary.model.Diary;
import io.github.happy1claire.diary.repository.DiaryRepository;
import io.github.happy1claire.diary.utils.FilterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing diary entries.
 */
@Service
public class DiaryService {

    /**
     * Repository for accessing diary entries in the database.
     */
    private final DiaryRepository diaryRepository;

    /**
     * Default sort order for diary entries.
     */
    private final Sort deafultSort = Sort.by(Sort.Direction.DESC, "createdAt");

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
        if (diary == null) {
            throw new IllegalArgumentException("Diary to add is null");
        }
        diaryRepository.save(diary);
    }

    /**
     * Method to delete an existing diary entry.
     * @param diaryId the diaryID to be deleted.
     */
    public void deleteDiary(Long diaryId) {
        if (diaryId == null) {
            throw new IllegalArgumentException("Diary ID to delete is null");
        }
        diaryRepository.deleteById(diaryId);
    }

    /**
     * Method to search diary entries based on various criteria.
     * Sort by the given sort.
     * @param request the filter request DTO
     * @param sortRequest the sort criteria
     * @return the filtered list of diary entries
     */
    public List<Diary> searchDiaries(FilterRequest request, SortRequest sortRequest) {
        Specification<Diary> spec = FilterUtils.makeFilter(request);
        Sort sort = sortRequest.toSpringSort(deafultSort); // Convert to Spring Sort
        return diaryRepository.findAll(spec, sort); // Use provided sort here
    }

}
