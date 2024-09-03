package com.proyectospringsurvey.survey.subresponseOptions.domain;

import com.proyectospringsurvey.survey.audit.domain.Audit;
import com.proyectospringsurvey.survey.responseOptions.domain.ResponseOptions;

import jakarta.persistence.CascadeType;
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
@Table(name = "subresponse_options")
@Getter
@Setter
@NoArgsConstructor
public class SubResponseOptions{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subresponse_number", columnDefinition = "int", nullable = false)
    private int subresponseNumber;

    @Embedded
    Audit audit = new Audit();

    @Column(name = "component_html", columnDefinition = "VARCHAR(255)", nullable = false)
    private String componentHtml;

    @Column(name = "subresponse_text", columnDefinition = "VARCHAR(255)", nullable = false)
    private String subresponseText;


    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "responseoptions_id")
    private ResponseOptions responseOptions;

    
}
