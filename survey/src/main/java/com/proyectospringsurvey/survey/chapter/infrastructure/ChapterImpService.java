package com.proyectospringsurvey.survey.chapter.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.chapter.application.IChapter;
import com.proyectospringsurvey.survey.chapter.domain.Chapter;

@Service
public class ChapterImpService implements IChapter{

    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    public Chapter createChapter(Chapter chapter) {
        return chapterRepository.save(null);
    }

    @Override
    public List<Chapter> getAllChapters() {
        return chapterRepository.findAll();
    }

    @Override
    public Chapter deleteChapterById(Long id) {
        Optional <Chapter> chapter = chapterRepository.findById(id);
        if(chapter.isPresent()){
            chapterRepository.deleteById(id);
            return chapter.get();
        }
        return null;
    }
    
}
