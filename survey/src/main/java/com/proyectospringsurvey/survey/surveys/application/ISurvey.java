package com.proyectospringsurvey.survey.surveys.application;

import java.util.List;
import java.util.Optional;

import com.proyectospringsurvey.survey.surveys.domain.Surveys;

public interface ISurvey {
     Surveys createSurvey(Long idCategoria, Surveys surveys);


     Optional<Surveys> findByIdSurveys(Long id);
     List<Surveys> getSurveysByIdCategory(Long id);
     Surveys partialUpdate(Surveys survey);
     void deleteSurvey(Long id);
}
