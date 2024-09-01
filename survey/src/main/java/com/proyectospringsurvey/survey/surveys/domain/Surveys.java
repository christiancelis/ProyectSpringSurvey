package com.proyectospringsurvey.survey.surveys.domain;


import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proyectospringsurvey.survey.audit.domain.Audit;
import com.proyectospringsurvey.survey.surveysCategory.domain.surveysCategory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "survey")
@NoArgsConstructor
public class Surveys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Embedded
    Audit audit = new Audit();
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "surveys" , cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<surveysCategory> categories_survey =  new HashSet<>();
    
    @Override
    public String toString() {
        return "Survey [id=" + id + ", audit=" + audit + ", description=" + description + ", name=" + name + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<surveysCategory> getCategories_survey() {
        return categories_survey;
    }

    public void setCategories_survey(surveysCategory categories_survey) {
        this.categories_survey.add(categories_survey);
    }
    
}