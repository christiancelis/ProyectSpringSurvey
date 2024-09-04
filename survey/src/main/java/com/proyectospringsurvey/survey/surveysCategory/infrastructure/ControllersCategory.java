package com.proyectospringsurvey.survey.surveysCategory.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectospringsurvey.survey.surveys.domain.Surveys;
import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/")
public class ControllersCategory {

    @Autowired
    private ImpServicesCategory impServicesCategory;


    @PostMapping("SurveyCategory")
    public ResponseEntity<?> createsCategory(@RequestBody Optional<surveysCategory> sCategory) {
        if(sCategory.isPresent()){
            return ResponseEntity.ok().body(impServicesCategory.createsCategory(sCategory.get()));
        } 
        return ResponseEntity.notFound().build();
    }

    @PostMapping("survey/category/{id}")
    public ResponseEntity<?> addSurveyToCategory(@PathVariable Long id, @RequestBody Surveys survey) {
       return ResponseEntity.ok().body(impServicesCategory.addSurveyToCategories(id, survey));
    }

    @GetMapping("SurveyCategory")
    public List<surveysCategory> getAllsCategory() {
        return impServicesCategory.getAllsCategory();
    }

    @GetMapping("SurveyCategory/{id}")
    public ResponseEntity<?> getsCategoryById(@PathVariable Long id){
        Optional<surveysCategory> scat = impServicesCategory.findByIdsCategory(id);
       if(scat.isPresent()){
           return  ResponseEntity.ok().body(scat.get());
       }
       return ResponseEntity.notFound().build();
    }

    @DeleteMapping("SurveyCategory/{id}")
    public ResponseEntity<?> deletesCategory(@PathVariable Long id){
        return ResponseEntity.ok().body(impServicesCategory.DeletesCategory(id));
    }
    
}
