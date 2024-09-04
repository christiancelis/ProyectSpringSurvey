package com.proyectospringsurvey.survey.surveys.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyectospringsurvey.survey.surveys.domain.Surveys;



import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class SurveyController {
    @Autowired
    private SurveyImpService surveyImpService;


    @GetMapping("survey")
    public List<Surveys> getSurveys() {
        return surveyImpService.getAllSurveys(); 
    }

    @GetMapping("survey/{id}")
    public ResponseEntity<Optional<Surveys>> getSurveyById(@PathVariable Long id) {
        if(surveyImpService.findByIdSurveys(id).isPresent()){
            return ResponseEntity.status(200).body(surveyImpService.findByIdSurveys(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("surveys/{id}")
    public ResponseEntity <?> getSurveyByCategoriaId(@PathVariable Long id) {
        if(surveyImpService.getSurveysByIdCategory(id)!=null){
            return ResponseEntity.ok().body(surveyImpService.getSurveysByIdCategory(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("survey")
    public Surveys createSurvey(@RequestBody Surveys surveyData) {
        return surveyImpService.createSurvey(surveyData); 
    }

    @DeleteMapping("survey/{id}")
    public ResponseEntity<?> createSurvey(@PathVariable Long id) {
        if(surveyImpService.deleteSurvey(id)==null){
            ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().body(surveyImpService.deleteSurvey(id));
    }

 

     

}
