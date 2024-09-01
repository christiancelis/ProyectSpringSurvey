package com.proyectospringsurvey.survey.chapter.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.chapter.application.IChapter;
import com.proyectospringsurvey.survey.chapter.domain.Chapter;
import com.proyectospringsurvey.survey.surveys.domain.Surveys;
import com.proyectospringsurvey.survey.surveys.infrastructure.SurveyRepository;

@Service
public class ChapterImpService implements IChapter{

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired 
    private SurveyRepository surveyRepository;


    @Override
    public Chapter createChapter(Long idSurvey, Chapter chapter) {
        Optional<Surveys> encuesta = surveyRepository.findById(idSurvey);
        if(encuesta.isPresent()){
            chapter.setSurveys(encuesta.get());
            return chapterRepository.save(chapter);
        }

        return null;
    }

    @Override
    public List<Chapter> getAllChapters(Long id) {
         Optional<Surveys> encuesta = surveyRepository.findById(id);
         if (encuesta.isPresent()) {
             return chapterRepository.findAllBySurveys_Id(id);
         } else {
             throw new RuntimeException("Survey not found");
         }
        
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
