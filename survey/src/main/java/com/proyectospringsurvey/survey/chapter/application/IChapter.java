package com.proyectospringsurvey.survey.chapter.application;

import java.util.List;


import com.proyectospringsurvey.survey.chapter.domain.Chapter;

public interface IChapter {
    Chapter createChapter(Chapter chapter);
    List<Chapter>getAllChapters();
    Chapter deleteChapterById(Long id);
}
