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
    public boolean DeletesCategoryByName(String name) {
        surveysCategory categoria = repositorysCategory.findByname(name);
        if(categoria.getName()!=name){
            categoria.getSurveys().removeAll(categoria.getSurveys());
            repositorysCategory.save(categoria);
            repositorysCategory.deleteByName(name);
            return true;
        }else{
            return false;
        }

    }

    
    
    
}
