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
import com.proyectospringsurvey.survey.utils.Patcher;

@Service
public class SurveyImpService implements ISurvey{

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    RepositorysCategory repositorysCategory;
    
    @Autowired
    Patcher patcher;
    


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

    @Override
    public Surveys partialUpdate(Surveys survey) {
        Optional <Surveys> encuestaExistente = surveyRepository.findById(survey.getId());
        if(encuestaExistente.isPresent()){
            try {
                Patcher.internPatcher(encuestaExistente.get(),survey);
                surveyRepository.save(encuestaExistente.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return encuestaExistente.get();
            
        }
  
        return null;
    }

    @Override
    public Surveys deleteSurvey(Long id) {
        Optional<Surveys> encuesta = surveyRepository.findById(id);

        if(encuesta.isPresent()){
            Surveys survey = encuesta.get();
            survey.getCategories_survey().clear();
            surveyRepository.save(survey);
            surveyRepository.deleteById(id);
            return survey;
        }

        return null;
    }
    
    

    
    
}
