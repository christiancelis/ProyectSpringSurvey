package com.proyectospringsurvey.survey.subresponseOptions.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectospringsurvey.survey.subresponseOptions.application.ISubResponseQuestions;
import com.proyectospringsurvey.survey.subresponseOptions.domain.SubResponseOptions;

@Service
public class SubResponseOptionsImpService implements ISubResponseQuestions{

     @Autowired
    private SubResponseOptionsRepository subresponseOptionsRepository;

    @Override
    public List<SubResponseOptions> getAllSubresponseOptions() {
        return subresponseOptionsRepository.findAll();
    }

    @Override
    public Optional<SubResponseOptions> getSubresponseOptionsById(Long id) {
        return subresponseOptionsRepository.findById(id);
    }

    @Override
    public SubResponseOptions createSubresponseOptions(SubResponseOptions subresponseOptions) {
        return subresponseOptionsRepository.save(subresponseOptions);
    }

    @Override
    public SubResponseOptions updateSubresponseOptions(Long id, SubResponseOptions updatedSubresponseOptions) {
        Optional<SubResponseOptions> subresponseOptions = subresponseOptionsRepository.findById(id);
        if (subresponseOptions.isPresent()) {
            SubResponseOptions existingSubresponseOptions = subresponseOptions.get();
            existingSubresponseOptions.setComponentHtml(updatedSubresponseOptions.getComponentHtml());
            existingSubresponseOptions.setSubresponseNumber(updatedSubresponseOptions.getSubresponseNumber());
            existingSubresponseOptions.setSubresponseText(updatedSubresponseOptions.getSubresponseText());
            existingSubresponseOptions.setResponseOptions(updatedSubresponseOptions.getResponseOptions());
            return subresponseOptionsRepository.save(existingSubresponseOptions);
        } else {
            return null;
        }
    }

    @Override
    public void deleteSubresponseOptions(Long id) {
        subresponseOptionsRepository.deleteById(id);
    }

}
