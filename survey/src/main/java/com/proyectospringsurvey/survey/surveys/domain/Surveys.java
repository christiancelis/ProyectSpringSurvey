package com.proyectospringsurvey.survey.surveys.domain;

import com.proyectospringsurvey.survey.audit.domain.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "surveys")
public class Surveys {
@Id
private Long id;
@Embedded
    Audit audit = new Audit();
    @Column
    private String description;
    @Column
    private String name;
    @Override
    public String toString() {
        return "Survey [id=" + id + ", audit=" + audit + ", description=" + description + ", name=" + name + "]";
    }
  
 

    
}
