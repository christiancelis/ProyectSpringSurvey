package com.proyectospringsurvey.survey.question.application;

import java.util.List;
import com.proyectospringsurvey.survey.question.domain.Question;

public interface IQuestion {
    Question createQuestion(Long idChapter, Question question);
    List<Question>getAllQuestions(Long idChapter);
    Question deleteQuestionById(Long idQuestion);
}
