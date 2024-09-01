package com.proyectospringsurvey.survey.responseOptions.infrastructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectospringsurvey.survey.responseOptions.domain.ResponseOptions;

@Repository
public interface ResponseOptionsRepository extends JpaRepository<ResponseOptions, Long> {
 List<ResponseOptions> findAllByQuestion_Id(Long id); 
}
