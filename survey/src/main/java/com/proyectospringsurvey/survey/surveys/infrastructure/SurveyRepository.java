package com.proyectospringsurvey.survey.surveys.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectospringsurvey.survey.surveys.domain.Surveys;

@Repository
public interface SurveyRepository extends JpaRepository<Surveys,Long>{
}

