package com.proyectospringsurvey.survey.surveys.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyectospringsurvey.survey.surveys.domain.Surveys;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/api/")
public class SurveyController {
    @Autowired
    private SurveyImpService surveyImpService;



    @GetMapping("survey/{id}")
    public ResponseEntity<Optional<Surveys>> getSurveyById(@PathVariable Long id) {
        if(surveyImpService.findByIdSurveys(id).isPresent()){
            return ResponseEntity.status(200).body(surveyImpService.findByIdSurveys(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("surveys/{idCategory}")
    public ResponseEntity <?> getSurveyByCategoriaId(@PathVariable Long idCategory) {
        if(surveyImpService.getSurveysByIdCategory(idCategory)!=null){
            return ResponseEntity.ok().body(surveyImpService.getSurveysByIdCategory(idCategory));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("survey/{idCategory}")
    public Surveys createSurvey(@PathVariable Long idCategory, @RequestBody Surveys surveyData) {
        return surveyImpService.createSurvey(idCategory, surveyData); 
    }

    @DeleteMapping("survey/{id}")
    public void createSurvey(@PathVariable Long id) {
            surveyImpService.deleteSurvey(id);
    }

 

     

}
