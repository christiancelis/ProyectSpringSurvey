package com.proyectospringsurvey.survey.question.domain;

import com.proyectospringsurvey.survey.audit.domain.Audit;
import com.proyectospringsurvey.survey.chapter.domain.Chapter;
import com.proyectospringsurvey.survey.surveys.domain.Surveys;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Embedded
    Audit audit = new Audit();
    
    @Column(name = "question_number",columnDefinition = "varchar(10)")
    private String questionNumber;
    @Column(name = "response_type",columnDefinition = "varchar(20)")
    private String responseType;
    @Column(name = "comment_question",columnDefinition = "text")
    private String commentQuestion;
    @Column(name = "question_text",columnDefinition = "text")
    private String questionText;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    
}
