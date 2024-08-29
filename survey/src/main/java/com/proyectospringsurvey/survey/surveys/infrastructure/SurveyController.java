package com.proyectospringsurvey.survey.surveys.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectospringsurvey.survey.surveys.domain.Surveys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/")
public class SurveyController {
    @Autowired
    private SurveyImpService surveyImpService;

    @PostMapping("/survey")
    public Surveys createSurvey(@RequestBody Surveys surveyData) {
        return surveyImpService.createSurvey(surveyData); 
    }
 

}
