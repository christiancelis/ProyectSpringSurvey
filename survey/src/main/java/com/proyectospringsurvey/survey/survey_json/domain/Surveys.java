package com.proyectospringsurvey.survey.survey_json.domain;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
    
    @Column(name = "create_at",columnDefinition = "timestamp")
    private LocalDateTime createdAt;
    
    @Column(name = "survey_id")
    private Long surveyId;
    
    @Column(name = "update_at",columnDefinition = "timestamp")

    private LocalDateTime updateAt;
    
    @Column(columnDefinition = "jsonb")
    private String payload;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Surveys [id=" + id + ", createdAt=" + createdAt + ", surveyId=" + surveyId + ", updateAt=" + updateAt
                + ", payload=" + payload + "]";
    }
}



