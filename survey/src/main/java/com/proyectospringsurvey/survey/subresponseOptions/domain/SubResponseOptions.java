package com.proyectospringsurvey.survey.subresponseOptions.domain;

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
@Table(name = "subresponse_options")
@Getter
@Setter
@NoArgsConstructor
public class SubResponseOptions{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subresponse_number", columnDefinition = "int(8)", nullable = false)
    private int subresponseNumber;

    @Embedded
    Audit audit = new Audit();

    @Column(name = "component_html", columnDefinition = "VARCHAR(255)", nullable = false)
    private String componentHtml;

    @Column(name = "supresponse_text", columnDefinition = "VARCHAR(255)", nullable = false)
    private String subresponseText;


  
}
