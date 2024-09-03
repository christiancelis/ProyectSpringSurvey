package com.proyectospringsurvey.survey.surveysCategory.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.surveys.domain.Surveys;
import com.proyectospringsurvey.survey.surveys.infrastructure.SurveyRepository;
import com.proyectospringsurvey.survey.surveysCategory.application.ISurveyCategory;
import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;

@Service
public class ImpServicesCategory implements ISurveyCategory{
    
    @Autowired
    private RepositorysCategory repositorysCategory;

    @Autowired
    private SurveyRepository surveyRepository;


    @Override
    public surveysCategory createsCategory(surveysCategory sCategory) {
        return repositorysCategory.save(sCategory);
    }

    @Override
    public List<surveysCategory> getAllsCategory() {
        return repositorysCategory.findAll();
    }

    @Override
    public Optional<surveysCategory> findByIdsCategory(Long id) {
        return repositorysCategory.findById(id);
    }

    @Override
    public surveysCategory DeletesCategory(Long id) {
        Optional<surveysCategory> sCat = repositorysCategory.findById(id);
        if(sCat.isPresent()){
            repositorysCategory.deleteById(id);
            return sCat.get();
        }

        return null;
    }

    @Override
    public surveysCategory addSurveyToCategories(Long idCategory, Surveys survey) {
        surveysCategory sCategory = repositorysCategory.findById(idCategory)
            .orElseThrow(() -> new RuntimeException("ID de categoría no válido"));
        // Guardar la encuesta si no está ya persistida
        if (survey.getId() == null) {
            survey = surveyRepository.save(survey);
        }
    
        // Asignar la encuesta a la categoría
        sCategory.setSurveys(survey);
    
        // Guardar la categoría con la encuesta asociada
        return repositorysCategory.saveAndFlush(sCategory);
    }
    
    
}
