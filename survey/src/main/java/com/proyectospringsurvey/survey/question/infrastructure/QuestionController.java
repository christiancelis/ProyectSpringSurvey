package com.proyectospringsurvey.survey.question.infrastructure;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectospringsurvey.survey.question.domain.Question;

@RestController
@RequestMapping("/api/")
public class QuestionController {

    @Autowired
    private QuestionImpService questionImpService;

    @GetMapping("question/{chapterid}")
    public List<Question> getAllQuestions(@PathVariable Long chapterid) {
        return questionImpService.getAllQuestions(chapterid);
    }

    

    @PostMapping("question/{chapterid}")
    public Question createQuestion(@PathVariable Long chapterid,@RequestBody Question question) {
        return questionImpService.createQuestion(chapterid, question);
        
    }

    @DeleteMapping("question/{id}")
    public Question deleteQuestion(@PathVariable Long id) {
        return questionImpService.deleteQuestionById(id);
    }  

}
