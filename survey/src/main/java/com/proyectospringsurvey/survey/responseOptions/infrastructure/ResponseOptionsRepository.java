package com.proyectospringsurvey.survey.responseOptions.infrastructure;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectospringsurvey.survey.responseOptions.domain.ResponseOptions;

public interface ResponseOptionsRepository extends JpaRepository<ResponseOptions, Long> {
 List<ResponseOptions> findAllByQuestion_Id(Long id); 
}
