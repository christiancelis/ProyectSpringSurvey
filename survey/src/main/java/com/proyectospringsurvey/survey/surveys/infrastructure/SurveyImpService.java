package com.proyectospringsurvey.survey.surveys.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.surveys.application.ISurvey;
import com.proyectospringsurvey.survey.surveys.domain.Surveys;

@Service
public class SurveyImpService implements ISurvey{

    @Autowired
    SurveyRepository surveyRepository;


    @Override
    public Surveys createSurvey(Surveys surveyData) {
        return surveyRepository.save(surveyData);
    }
    
}
