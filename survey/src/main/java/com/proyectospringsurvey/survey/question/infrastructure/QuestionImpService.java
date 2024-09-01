package com.proyectospringsurvey.survey.question.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.chapter.domain.Chapter;
import com.proyectospringsurvey.survey.chapter.infrastructure.ChapterRepository;
import com.proyectospringsurvey.survey.question.application.IQuestion;
import com.proyectospringsurvey.survey.question.domain.Question;
import com.proyectospringsurvey.survey.surveys.domain.Surveys;

@Service
public class QuestionImpService implements IQuestion{

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ChapterRepository chapterRepository;



    @Override
    public Question createQuestion(Long idChapter, Question question) {
       Optional<Chapter> capitulo = chapterRepository.findById(idChapter);
        if(capitulo.isPresent()){
            question.setChapter(capitulo.get());
            return questionRepository.save(question);
        }

        return null;
    }

    @Override
    public List<Question> getAllQuestions(Long idChapter) {
        Optional<Chapter> capitulo = chapterRepository.findById(idChapter);
        if (capitulo.isPresent()) {
            return questionRepository.findAllByChapter_id(idChapter);
        } else {
            throw new RuntimeException("Chapter not found");
        }
    }

    @Override
    public Question deleteQuestionById(Long idQuestion) {
        Optional <Question> pregunta = questionRepository.findById(idQuestion);
        if(pregunta.isPresent()){
            questionRepository.deleteById(idQuestion);
            return pregunta.get();
        }
        return null;
    }
    
}
