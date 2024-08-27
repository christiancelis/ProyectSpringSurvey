package com.proyectospringsurvey.survey.question.domain;

import java.time.LocalDateTime;

import org.hibernate.mapping.ManyToOne;

import com.proyectospringsurvey.survey.audit.domain.Audit;
import com.proyectospringsurvey.survey.chapter.domain.Chapter;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Column(name ="chapter_id")
    private Long chapterId;
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


 
    Chapter chapter;



    @Override
    public String toString() {
        return "Question [id=" + id + ", chapterId=" + chapterId + ", audit=" + audit + ", questionNumber="
                + questionNumber + ", responseType=" + responseType + ", commentQuestion=" + commentQuestion
                + ", questionText=" + questionText + "]";
    }


    

}
