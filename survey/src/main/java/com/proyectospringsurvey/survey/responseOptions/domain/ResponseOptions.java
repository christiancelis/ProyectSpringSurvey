package com.proyectospringsurvey.survey.responseOptions.domain;

import com.proyectospringsurvey.survey.audit.domain.Audit;
import com.proyectospringsurvey.survey.categoriesCatalog.domain.CategoriesCatalog;
import com.proyectospringsurvey.survey.question.domain.Question;

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
@Table(name = "response_options")

@Getter
@Setter
@NoArgsConstructor
public class ResponseOptions {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "option_value", columnDefinition = "VARCHAR(10)", nullable = false)
    private String optionValue;
    
    @Embedded
    Audit audit = new Audit();

    @Column(name = "typecomponenthtml", columnDefinition = "VARCHAR(30)", nullable = false)
    private String typeComponentHtml;

    @Column(name = "comment_response", columnDefinition="TEXT", nullable = false)
    private String comment_response;

    @Column(name = "option_text", columnDefinition = "TEXT", nullable = false)
    private String optionText;

    @ManyToOne
    @JoinColumn(name = "parentresponse_id")
    private ResponseOptions responseOptions;
    
    @ManyToOne
    @JoinColumn(name = "questions_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "categorycatalog_id")
    private CategoriesCatalog categoriesCatalog;
   

}
