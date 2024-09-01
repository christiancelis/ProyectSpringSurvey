package com.proyectospringsurvey.survey.categoriesCatalog.application;

import java.util.List;
import java.util.Optional;

import com.proyectospringsurvey.survey.categoriesCatalog.domain.CategoriesCatalog;

public interface ICategoryCatalog {
    List<CategoriesCatalog> getAllCategoriesCatalog();
    Optional<CategoriesCatalog> getCategoriesCatalogById(Long id);
    CategoriesCatalog createCategoriesCatalog(CategoriesCatalog categoriesCatalog);
    CategoriesCatalog updateCategoriesCatalog(Long id, CategoriesCatalog updatedCategoriesCatalog);
    void deleteCategoriesCatalog(Long id);
    
}
