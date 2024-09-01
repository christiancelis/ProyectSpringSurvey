package com.proyectospringsurvey.survey.categoriesCatalog.infrastructure;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectospringsurvey.survey.categoriesCatalog.domain.CategoriesCatalog;

@RestController
@RequestMapping("/api/")
public class CategoriesCatalogController {

    @Autowired
    private CategoriesCatalogImpService catalogImpService;


    @GetMapping("categoriescatalog")
    public List<CategoriesCatalog> getAllCategoriesCatalog() {
        return catalogImpService.getAllCategoriesCatalog();
    }

    @GetMapping("categoriescatalog/{id}")
    public ResponseEntity<CategoriesCatalog> getCategoriesCatalogById(@PathVariable Long id) {
        Optional<CategoriesCatalog> categoriesCatalog = catalogImpService.getCategoriesCatalogById(id);
        return categoriesCatalog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("categoriescatalog")
    public ResponseEntity<CategoriesCatalog> createCategoriesCatalog(@RequestBody CategoriesCatalog categoriesCatalog) {
        CategoriesCatalog createdCategoriesCatalog = catalogImpService.createCategoriesCatalog(categoriesCatalog);
        return ResponseEntity.ok(createdCategoriesCatalog);
    }

    @PutMapping("categoriescatalog/{id}")
    public ResponseEntity<CategoriesCatalog> updateCategoriesCatalog(@PathVariable Long id, @RequestBody CategoriesCatalog updatedCategoriesCatalog) {
        CategoriesCatalog categoriesCatalog = catalogImpService.updateCategoriesCatalog(id, updatedCategoriesCatalog);
        if (categoriesCatalog != null) {
            return ResponseEntity.ok(categoriesCatalog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("categoriescatalog/{id}")
    public ResponseEntity<Void> deleteCategoriesCatalog(@PathVariable Long id) {
        catalogImpService.deleteCategoriesCatalog(id);
        return ResponseEntity.noContent().build();
    }
}
