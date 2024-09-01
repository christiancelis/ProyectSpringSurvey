package com.proyectospringsurvey.survey.responseOptions.application;

import java.util.List;
import com.proyectospringsurvey.survey.responseOptions.domain.ResponseOptions;

public interface IResponseOptions {
    ResponseOptions createResponseOption(Long idQuestion, ResponseOptions responseOptions);
    List<ResponseOptions>getAllResponseOptions(Long idQuestion);
    ResponseOptions deleteResponseOptionById(Long id);
}
