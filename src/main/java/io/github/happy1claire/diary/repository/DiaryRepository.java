package io.github.happy1claire.diary.repository;

import io.github.happy1claire.diary.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
