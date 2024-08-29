package com.proyectospringsurvey.survey.surveys.domain;

import com.proyectospringsurvey.survey.audit.domain.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "surveys")
@Getter
@Setter
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
    
    @Override
    public String toString() {
        return "Survey [id=" + id + ", audit=" + audit + ", description=" + description + ", name=" + name + "]";
    }

}