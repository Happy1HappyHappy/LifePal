package io.github.happy1claire.diary.service;

import io.github.happy1claire.diary.model.Diary;
import io.github.happy1claire.diary.model.Mood;
import io.github.happy1claire.diary.repository.DiaryRepository;
import io.github.happy1claire.diary.specification.DairySpecifications;
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
     * @return
     */
    public void addNewDairy(Diary diary) {
        diaryRepository.save(diary);
    }


    public List<Diary> searchDiaries(Mood mood, String titleKeyword) {
        Specification<Diary> spec = Specification.where(null);

        if (mood != null) {
            spec = spec.and(DairySpecifications.hasMood(mood));
        }
        if (titleKeyword != null && !titleKeyword.isEmpty()) {
            spec = spec.and(DairySpecifications.hasTitleContaining(titleKeyword));
        }

        return diaryRepository.findAll(spec);
    }

    public Diary getDiaryById(int id) {
        return diaryRepository.findAll();
    }

    public Diary getDiaryByName(String name) {
        return null;
    }

}
