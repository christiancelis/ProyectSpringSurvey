package com.proyectospringsurvey.survey.surveysCategory.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proyectospringsurvey.survey.surveysCategory.domain.surveyCategoryDto;
import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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


   @PutMapping("SurveyCategory")
public ResponseEntity<?> actualizarCategoria(@RequestBody surveyCategoryDto surveyCategoryDto) {
    Optional<surveysCategory> categoryval = impServicesCategory.findByIdsCategory(surveyCategoryDto.getCategoryId());
    
    if (categoryval.isPresent()) {
        surveysCategory category = categoryval.get();
        category.setName(surveyCategoryDto.getCategoryName());
        return ResponseEntity.ok().body(impServicesCategory.actualizarCategoria(category));
    }
    
    // Lanzar excepción si no se encuentra la categoría
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoría no encontrada");
}

@DeleteMapping("SurveyCategory/{id}")
public ResponseEntity<?> deletesCategory(@PathVariable Long id){
    boolean validacion =  impServicesCategory.DeletesCategoryById(id);
    if(validacion){
         return ResponseEntity.ok().body(null);
    } else {
         return ResponseEntity.internalServerError().build();
    }
}

}
