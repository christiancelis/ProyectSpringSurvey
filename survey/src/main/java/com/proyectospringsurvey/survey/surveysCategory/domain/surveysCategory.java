package com.proyectospringsurvey.survey.surveysCategory.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proyectospringsurvey.survey.audit.domain.Audit;
import com.proyectospringsurvey.survey.surveys.domain.Surveys;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "survey_category_catalog") 
@NoArgsConstructor
public class surveysCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Embedded
    Audit audit = new Audit();

    
    @Column(columnDefinition = "VARCHAR(20)", unique = true)
    private String name;

    @OneToMany(mappedBy = "sCat", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    List<Surveys> surveys = new ArrayList<>();

    


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Surveys> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Surveys> surveys) {
        this.surveys = surveys;
    }

    
    
}
