package com.proyectospringsurvey.survey.question.infrastructure;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectospringsurvey.survey.question.domain.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
  List<Question> findAllByChapter_id(Long id); 
}
