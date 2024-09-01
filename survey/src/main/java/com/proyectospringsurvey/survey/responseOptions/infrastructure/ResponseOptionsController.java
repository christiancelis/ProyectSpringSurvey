package com.proyectospringsurvey.survey.responseOptions.infrastructure;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectospringsurvey.survey.chapter.domain.Chapter;
import com.proyectospringsurvey.survey.responseOptions.domain.ResponseOptions;

@RestController
@RequestMapping("/api/")
public class ResponseOptionsController {

    @Autowired
    private  ResponseOptionsImpService responseOptionsImpService;

    
    @GetMapping("responseoptions/{questionid}")
    public List<ResponseOptions> getAllChapters(@PathVariable Long questionid) {
        return responseOptionsImpService.getAllResponseOptions(questionid);
    }

    

    @PostMapping("responseoptions/{questionid}")
    public ResponseOptions createResponseOptions(@PathVariable Long questionid,@RequestBody ResponseOptions responseOptions) {
        return responseOptionsImpService.createResponseOption(questionid,responseOptions);
        
    }

    @DeleteMapping("responseoptions/{id}")
    public ResponseOptions deleteChapter(@PathVariable Long id) {
        return responseOptionsImpService.deleteResponseOptionById(id);
    }  



}
