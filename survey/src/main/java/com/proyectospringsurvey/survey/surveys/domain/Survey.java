package com.proyectospringsurvey.survey.surveys.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
@Table(name = "surve")
public class Survey {
@Id
private Long id;
@Column(name = "create_at",columnDefinition = "timestamp")
    private LocalDateTime createdAt;
    @Column(name = "update_at",columnDefinition = "timestamp")
    private LocalDateTime updateAt;
    @Column
    private String description;
    @Column
    private String name;
    @Override
    public String toString() {
        return "Survey [id=" + id + ", createdAt=" + createdAt + ", updateAt=" + updateAt + ", description="
                + description + ", name=" + name + "]";
    }

    
}
