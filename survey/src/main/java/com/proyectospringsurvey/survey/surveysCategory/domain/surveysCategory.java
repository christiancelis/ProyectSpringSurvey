package com.proyectospringsurvey.survey.surveysCategory.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @Column(columnDefinition = "VARCHAR(20)")
    private String name;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JsonManagedReference
    @JoinTable(
        name = "categories_survey",
        joinColumns = @JoinColumn(name = "categories_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "survey_id", referencedColumnName = "id")
    ) 
    private Set<Surveys> surveys =  new HashSet<>();

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

    public Set<Surveys> getSurveys() {
        return surveys;
    }

    public void setSurveys(Surveys surveys) {
        this.surveys.add(surveys);
    }
    
}
