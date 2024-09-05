package com.proyectospringsurvey.survey.surveys.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectospringsurvey.survey.surveys.domain.Surveys;
import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;


@Repository
public interface SurveyRepository extends JpaRepository<Surveys,Long>{
    List<Surveys> findAllBySCat(surveysCategory sCat);
    List<Surveys> deleteAllBySCat_Name(String categoryName);
}

