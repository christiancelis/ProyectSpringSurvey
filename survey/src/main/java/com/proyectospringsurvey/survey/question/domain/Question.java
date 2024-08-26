package com.proyectospringsurvey.survey.question.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
    @Column(name = "create_at",columnDefinition = "timestamp")
    private LocalDateTime createdAt;
    @Column(name = "update_at",columnDefinition = "timestamp")
    private LocalDateTime updateAt;
    @Column(name = "question_number",columnDefinition = "varhar(10)")
    private String questionNumber;
    @Column(name = "response_type",columnDefinition = "varchar(20)")
    private String responseType;
    @Column(name = "comment_question",columnDefinition = "text")
    private String commentQuestion;
    @Column(name = "question_text",columnDefinition = "text")
    private String questionText;
    @Override
    public String toString() {
        return "Question [id=" + id + ", chapterId=" + chapterId + ", createdAt=" + createdAt + ", updateAt=" + updateAt
                + ", questionNumber=" + questionNumber + ", responseType=" + responseType + ", commentQuestion="
                + commentQuestion + ", questionText=" + questionText + "]";
    }

    

}
