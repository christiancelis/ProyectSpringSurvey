package com.proyectospringsurvey.survey.surveysCategory.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectospringsurvey.survey.surveys.infrastructure.SurveyRepository;
import com.proyectospringsurvey.survey.surveysCategory.application.ISurveyCategory;
import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;

@Service
public class ImpServicesCategory implements ISurveyCategory{
    
    @Autowired
    private RepositorysCategory repositorysCategory;

    @Autowired
    SurveyRepository surveyRepository;

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
@Transactional
public boolean DeletesCategoryById(Long id) {
    try {
        Optional<surveysCategory> categoria = repositorysCategory.findById(id);
        if (categoria.isPresent()) {
            categoria.get().getSurveys().clear(); // Limpiar relaciones si es necesario
            repositorysCategory.deleteById(id);
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
        // Log del error para más detalles
        e.printStackTrace();
        return false;
    }
}

@Transactional
@Override
public surveysCategory actualizarCategoria(surveysCategory sCategory) {
    return repositorysCategory.save(sCategory);
}
    
    
}
