package com.proyectospringsurvey.survey.surveysCategory.application;

import java.util.List;
import java.util.Optional;

import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;

public interface ISurveyCategory {
     surveysCategory createsCategory(surveysCategory sCategory);
     List<surveysCategory> getAllsCategory();
     Optional<surveysCategory> findByIdsCategory(Long id);
     boolean DeletesCategoryByName(String name);
     boolean DeletesCategoryById(Long id);
}
