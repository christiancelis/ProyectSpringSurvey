package com.proyectospringsurvey.survey.surveys.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectospringsurvey.survey.surveys.domain.Surveys;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/")
public class SurveyController {
    @Autowired
    private SurveyImpService surveyImpService;

    @GetMapping("survey")
    public List<Surveys> getSurveys() {
        return surveyImpService.getAllSurveys(); 
    }

    @GetMapping("survey/{id}")
    public ResponseEntity<Optional<Surveys>> getMethodName(@PathVariable Long id) {
        if(surveyImpService.findByIdSurveys(id).isPresent()){
            return ResponseEntity.status(200).body(surveyImpService.findByIdSurveys(id));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    
 

    @PostMapping("survey")
    public Surveys createSurvey(@RequestBody Surveys surveyData) {
        return surveyImpService.createSurvey(surveyData); 
    }


 

}
