package com.proyectospringsurvey.survey.chapter.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
@Table(name = "chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "create_at", columnDefinition = "timestamp")
    private LocalDateTime createdAt;
    @Column(name = "survey_id")
    private Long surveyId;/*FORANEA */
    @Column(name = "update_at",columnDefinition = "timestamp")
    private LocalDateTime updateAt;
    @Column(name = "chapter_number",columnDefinition = "varchar(50)")
    private String chapterNumer;
    @Column(name = "chapter_title",columnDefinition = "varchar(50)")
    private String chapterTitle;
    
}
