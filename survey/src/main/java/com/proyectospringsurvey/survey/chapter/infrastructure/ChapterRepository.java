package com.proyectospringsurvey.survey.chapter.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectospringsurvey.survey.chapter.domain.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter,Long> {

}
