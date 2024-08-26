package com.proyectospringsurvey.survey.chapter.domain;

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
@Table(name = "chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  @Embedded
    Audit audit = new Audit();
    @Column(name = "survey_id")
    private Long surveyId;/*FORANEA */
  
    @Column(name = "chapter_number",columnDefinition = "varchar(50)")
    private String chapterNumer;
    @Column(name = "chapter_title",columnDefinition = "varchar(50)")
    private String chapterTitle;
    @Override
    public String toString() {
        return "Chapter [id=" + id + ", audit=" + audit + ", surveyId=" + surveyId + ", chapterNumer=" + chapterNumer
                + ", chapterTitle=" + chapterTitle + "]";
    }
    

    
}
