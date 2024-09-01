package com.proyectospringsurvey.survey.chapter.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectospringsurvey.survey.chapter.domain.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter,Long> {

}
