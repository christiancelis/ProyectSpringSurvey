package com.proyectospringsurvey.survey.surveysCategory.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;

@Repository
public interface RepositorysCategory extends JpaRepository<surveysCategory,Long>{
}
