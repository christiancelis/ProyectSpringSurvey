package com.proyectospringsurvey.survey.surveys.infrastructure;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.surveys.application.ISurvey;
import com.proyectospringsurvey.survey.surveys.domain.Surveys;
import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;
import com.proyectospringsurvey.survey.surveysCategory.infrastructure.RepositorysCategory;

@Service
public class SurveyImpService implements ISurvey{

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    RepositorysCategory repositorysCategory;


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

    @Override
    public Set<Surveys> getSurveysByIdCategory(Long id){
        Optional<surveysCategory> categoria = repositorysCategory.findById(id);
        if(categoria.isPresent()){
            return categoria.get().getSurveys();
        }
        return null;
    }

    
    

    
    
}
