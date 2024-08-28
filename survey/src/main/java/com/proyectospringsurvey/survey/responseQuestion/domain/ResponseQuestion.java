package com.proyectospringsurvey.survey.responseQuestion.domain;

import com.proyectospringsurvey.survey.responseOptions.domain.ResponseOptions;
import com.proyectospringsurvey.survey.subresponseOptions.domain.SubResponseOptions;

import jakarta.persistence.Column;
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
@Table(name = "response_questions")
@Getter
@Setter
@NoArgsConstructor
public class ResponseQuestion{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(columnDefinition = "VARCHAR(80)", nullable=false)
   private String responseText;

   @ManyToOne
   @JoinColumn(name = "subresponses_id")
   private SubResponseOptions subResponseOptions;

   @ManyToOne
   @JoinColumn(name = "responses_id")
   private ResponseOptions responseOptions;
   
}
