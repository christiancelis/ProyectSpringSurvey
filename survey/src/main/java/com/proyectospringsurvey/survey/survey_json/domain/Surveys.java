package com.proyectospringsurvey.survey.survey_json.domain;
import java.time.LocalDateTime;

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
@Getter
@Setter
@NoArgsConstructor
@Table(name = "surveys")
public class Surveys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "survey_id")
    private Long surveyId;

    @Embedded
    Audit audit = new Audit();
    
    @Column(columnDefinition = "jsonb")
    private String payload;

    @Override
    public String toString() {
        return "Surveys [id=" + id + ", surveyId=" + surveyId + ", audit=" + audit + ", payload=" + payload + "]";
    }

    

    
}



