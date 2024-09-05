package com.proyectospringsurvey.survey.surveysCategory.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/")
public class ControllersCategory {

    @Autowired
    private ImpServicesCategory impServicesCategory;

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


    @PostMapping("SurveyCategory")
    public ResponseEntity<?> createsCategory(@RequestBody Optional<surveysCategory> sCategory) {
        if(sCategory.isPresent()){
            return ResponseEntity.ok().body(impServicesCategory.createsCategory(sCategory.get()));
        } 
        return ResponseEntity.notFound().build();
    }

  

  @DeleteMapping("SurveyCategory/{name}")
public ResponseEntity<String> deletesCategory(@PathVariable String name) {
    try {
        boolean validacion = impServicesCategory.DeletesCategoryByName(name);
        if (validacion) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Error al eliminar la categoría: " + e.getMessage());
    }
}

     @DeleteMapping("SurveyCategory/{id}")
    public ResponseEntity<?> deletesCategory(@PathVariable Long id){
        boolean validacion = impServicesCategory.DeletesCategoryById(id);
        if(validacion){
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.notFound().build(); // Retorna NotFound si no se encontró la categoría
        }
    }

}
