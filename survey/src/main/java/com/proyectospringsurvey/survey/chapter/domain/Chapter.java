package com.proyectospringsurvey.survey.chapter.domain;

import com.proyectospringsurvey.survey.audit.domain.Audit;
import com.proyectospringsurvey.survey.surveys.domain.Surveys;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    
    @Embedded
    Audit audit = new Audit();
    
    @Column(name = "chapter_number", columnDefinition = "varchar(50)")
    private String chapterNumber; // Cambiado a chapterNumber para mayor claridad
    @Column(name = "chapter_title", columnDefinition = "varchar(50)")
    private String chapterTitle;
   
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Surveys surveys;
    
}

