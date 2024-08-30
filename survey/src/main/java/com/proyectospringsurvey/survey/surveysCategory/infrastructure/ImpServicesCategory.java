package com.proyectospringsurvey.survey.surveysCategory.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proyectospringsurvey.survey.surveysCategory.application.ISurveyCategory;
import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;

@Service
public class ImpServicesCategory implements ISurveyCategory{
    
    @Autowired
    private RepositorysCategory repositorysCategory;


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
    
}
