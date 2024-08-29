package com.proyectospringsurvey.survey.surveys.application;

import java.util.List;
import java.util.Optional;

import com.proyectospringsurvey.survey.surveys.domain.Surveys;

public interface ISurvey {
     Surveys createSurvey(Surveys surveys);
     List<Surveys> getAllSurveys();
     Optional<Surveys> findByIdSurveys(Long id);
}
