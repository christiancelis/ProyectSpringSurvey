package com.proyectospringsurvey.survey.responseOptions.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.question.domain.Question;
import com.proyectospringsurvey.survey.question.infrastructure.QuestionRepository;
import com.proyectospringsurvey.survey.responseOptions.application.IResponseOptions;
import com.proyectospringsurvey.survey.responseOptions.domain.ResponseOptions;


@Service
public class ResponseOptionsImpService implements IResponseOptions{
    @Autowired
    private ResponseOptionsRepository responseOptionsRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public ResponseOptions createResponseOption(Long idQuestion, ResponseOptions responseOptions) {
       Optional<Question> pregunta = questionRepository.findById(idQuestion);
        if(pregunta.isPresent()){
            responseOptions.setQuestion(pregunta.get());
            return responseOptionsRepository.save(responseOptions);
        }

        return null;
    }

    @Override
    public List<ResponseOptions> getAllResponseOptions(Long idQuestion) {
         Optional<Question> pregunta = questionRepository.findById(idQuestion);
         if (pregunta.isPresent()) {
             return responseOptionsRepository.findAllByQuestion_Id(idQuestion);
         } else {
             throw new RuntimeException("Question not found");
         }
    }

    @Override
    public ResponseOptions deleteResponseOptionById(Long id) {
         Optional <ResponseOptions> opcionRespuesta = responseOptionsRepository.findById(id);
        if(opcionRespuesta.isPresent()){
            responseOptionsRepository.deleteById(id);
            return opcionRespuesta.get();
        }
        return null;
    }
    
}
