package com.proyectospringsurvey.survey.categoriesCatalog.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectospringsurvey.survey.categoriesCatalog.domain.CategoriesCatalog;

@Repository
public interface CategoriesCatalogRepository extends JpaRepository<CategoriesCatalog,Long> {
}
