package com.proyectospringsurvey.survey.surveys.infrastructure;

import java.util.List;
import java.util.Optional;

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
    public Surveys createSurvey(Long idCategory,Surveys survey) {
        surveysCategory sCategory = repositorysCategory.findById(idCategory)
        .orElseThrow(() -> new RuntimeException("ID de categoría no válido"));
    // Guardar la encuesta si no está ya persistida
    if (survey.getId() == null) {
        survey.setsCat(sCategory);
        surveyRepository.save(survey);
        return survey;
    }
    
    return null;
    }

    
   
    @Override
    public Optional<Surveys> findByIdSurveys(Long id) {
        return surveyRepository.findById(id);
    }

    @Override
    public List<Surveys> getSurveysByIdCategory(Long id){
        Optional<surveysCategory> categoria = repositorysCategory.findById(id);
        if(categoria.isPresent()){
            return surveyRepository.findAllBySCat(categoria.get());
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
    public void deleteSurvey(Long id) {

        Optional<Surveys> encuesta = surveyRepository.findById(id);

        if(encuesta.isPresent()){
            Surveys survey = encuesta.get();
            survey.setsCat(null);
            surveyRepository.save(encuesta.get());
            surveyRepository.deleteById(id);
            return;
        }

    }
    
    

    
    
}
