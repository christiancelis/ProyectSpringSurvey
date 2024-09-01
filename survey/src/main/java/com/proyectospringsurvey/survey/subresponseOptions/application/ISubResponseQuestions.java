package com.proyectospringsurvey.survey.subresponseOptions.application;
import java.util.List;
import java.util.Optional;

import com.proyectospringsurvey.survey.subresponseOptions.domain.SubResponseOptions;

public interface ISubResponseQuestions {
    List<SubResponseOptions> getAllSubresponseOptions();
    Optional<SubResponseOptions> getSubresponseOptionsById(Long id);
    SubResponseOptions createSubresponseOptions(SubResponseOptions subresponseOptions);
    SubResponseOptions updateSubresponseOptions(Long id, SubResponseOptions updatedSubresponseOptions);
    public void deleteSubresponseOptions(Long id);
}
