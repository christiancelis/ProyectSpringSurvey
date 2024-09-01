package com.proyectospringsurvey.survey.subresponseOptions.infrastructure;

import java.util.List;
import java.util.Optional;
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

import com.proyectospringsurvey.survey.subresponseOptions.domain.SubResponseOptions;

@RestController
@RequestMapping("/api/")
public class SubResponseOptionsController {
   
    @Autowired
    private SubResponseOptionsImpService subResponseOptionsImpService;

    @GetMapping
    public List<SubResponseOptions> getAllSubresponseOptions() {
        return subResponseOptionsImpService.getAllSubresponseOptions();
    }

    @GetMapping("subresponseoptions/{id}")
    public ResponseEntity<SubResponseOptions> getSubresponseOptionsById(@PathVariable Long id) {
        Optional<SubResponseOptions> subresponseOptions = subResponseOptionsImpService.getSubresponseOptionsById(id);
        return subresponseOptions.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("subresponseoptions")
    public ResponseEntity<SubResponseOptions> createSubresponseOptions(@RequestBody SubResponseOptions subresponseOptions) {
        SubResponseOptions createdSubresponseOptions = subResponseOptionsImpService.createSubresponseOptions(subresponseOptions);
        return ResponseEntity.ok(createdSubresponseOptions);
    }

    @PutMapping("(subresponseoptions/{id}")
    public ResponseEntity<SubResponseOptions> updateSubresponseOptions(@PathVariable Long id, @RequestBody SubResponseOptions updatedSubresponseOptions) {
        SubResponseOptions subresponseOptions = subResponseOptionsImpService.updateSubresponseOptions(id, updatedSubresponseOptions);
        if (subresponseOptions != null) {
            return ResponseEntity.ok(subresponseOptions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("(subresponseoptions/{id}")
    public ResponseEntity<Void> deleteSubresponseOptions(@PathVariable Long id) {
        subResponseOptionsImpService.deleteSubresponseOptions(id);
        return ResponseEntity.noContent().build();
    }
}
