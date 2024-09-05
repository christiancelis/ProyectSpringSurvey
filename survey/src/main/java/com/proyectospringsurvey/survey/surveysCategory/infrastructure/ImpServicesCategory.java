package com.proyectospringsurvey.survey.surveysCategory.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectospringsurvey.survey.surveys.infrastructure.SurveyRepository;
import com.proyectospringsurvey.survey.surveysCategory.application.ISurveyCategory;
import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;

@Service
public class ImpServicesCategory implements ISurveyCategory{
    
    @Autowired
    private RepositorysCategory repositorysCategory;

    @Autowired
    SurveyRepository surveyRepository;

    @Override
    public surveysCategory createsCategory(surveysCategory sCategory) {
        return repositorysCategory.save(sCategory);
    }

    @Override
    public List<surveysCategory> getAllsCategory() {
        return repositorysCategory.findAll();
    }

    @Override
    public Optional<surveysCategory> findByIdsCategory(Long id) {
        return repositorysCategory.findById(id);
    }

     
//    @Override
//     @Transactional
//     public boolean DeletesCategoryByName(String name) {
//         surveysCategory categoria = repositorysCategory.findByname(name);
//         if (categoria != null) {
//             // Primero, elimina las encuestas asociadas
//             for (Surveys encuesta : categoria.getSurveys()) {
//                 encuesta.setCategory(null); // Desasocia la encuesta de la categoría
//                 surveyRepository.save(encuesta); // Guarda los cambios
//             }
//             // Luego, elimina la categoría
//             repositorysCategory.delete(categoria);
//             return true;
//         } else {
//             return false; // Categoría no encontrada
//         }
//     }

     @Override
    @Transactional
    public boolean DeletesCategoryById(Long id) {
        Optional<surveysCategory> categoria = repositorysCategory.findById(id);
        if (categoria.isPresent()) {
            // Maneja las relaciones antes de eliminar la categoría si es necesario
            // Ejemplo: categoria.get().getSurveys().clear();
            
            repositorysCategory.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean DeletesCategoryByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DeletesCategoryByName'");
    }

    
    
    
}
