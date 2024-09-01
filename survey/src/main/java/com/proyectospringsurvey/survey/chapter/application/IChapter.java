package com.proyectospringsurvey.survey.chapter.application;

import java.util.List;


import com.proyectospringsurvey.survey.chapter.domain.Chapter;

public interface IChapter {
    Chapter createChapter(Long idSurvey, Chapter chapter);
    List<Chapter>getAllChapters(Long idSurvey);
    Chapter deleteChapterById(Long idSurvey);
}
