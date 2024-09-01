package com.proyectospringsurvey.survey.categoriesCatalog.infrastructure;

import java.util.List;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.categoriesCatalog.application.ICategoryCatalog;
import com.proyectospringsurvey.survey.categoriesCatalog.domain.CategoriesCatalog;

@Service
public class CategoriesCatalogImpService implements ICategoryCatalog {
    
    @Autowired
    private CategoriesCatalogRepository categoriesCatalogRepository;


    public List<CategoriesCatalog> getAllCategoriesCatalog() {
        return categoriesCatalogRepository.findAll();
    }

    public Optional<CategoriesCatalog> getCategoriesCatalogById(Long id) {
        return categoriesCatalogRepository.findById(id);
    }

    public CategoriesCatalog createCategoriesCatalog(CategoriesCatalog categoriesCatalog) {
        return categoriesCatalogRepository.save(categoriesCatalog);
    }

    public CategoriesCatalog updateCategoriesCatalog(Long id, CategoriesCatalog updatedCategoriesCatalog) {
        Optional<CategoriesCatalog> categoriesCatalog = categoriesCatalogRepository.findById(id);
        if (categoriesCatalog.isPresent()) {
            CategoriesCatalog existingCategoriesCatalog = categoriesCatalog.get();
            existingCategoriesCatalog.setName(updatedCategoriesCatalog.getName());
            return categoriesCatalogRepository.save(existingCategoriesCatalog);
        } else {
            return null;
        }
    }

    public void deleteCategoriesCatalog(Long id) {
        categoriesCatalogRepository.deleteById(id);
    }

}
