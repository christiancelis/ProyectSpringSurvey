package com.proyectospringsurvey.survey.surveysCategory.domain;

import java.util.List;

import com.proyectospringsurvey.survey.audit.domain.Audit;
import com.proyectospringsurvey.survey.surveys.domain.Surveys;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "survey_category_catalog")
@Setter
@Getter 
@NoArgsConstructor
public class surveysCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Embedded
    Audit audit = new Audit();

    @Column(columnDefinition = "VARCHAR(20)")
    private String name;

    @ManyToMany()
    @JoinTable(
        name = "categories_survey",
        joinColumns = @JoinColumn(name = "categories_id"),
        inverseJoinColumns = @JoinColumn(name = "survey_id")
    ) 
    private List<Surveys> surveys;
}
