package com.proyectospringsurvey.survey.surveys.infrastructure;

import java.util.List;
import java.util.Optional;

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
    
    @Override
    public List<Surveys> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @Override
    public Optional<Surveys> findByIdSurveys(Long id) {
        return surveyRepository.findById(id);
    }

    

    
    
}
