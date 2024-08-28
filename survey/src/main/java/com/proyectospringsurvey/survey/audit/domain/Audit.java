package com.proyectospringsurvey.survey.audit.domain;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class Audit {
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onPrePersistAudit(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onPreUpdateAudit(){
        this.updatedAt = LocalDateTime.now();
    }


}
