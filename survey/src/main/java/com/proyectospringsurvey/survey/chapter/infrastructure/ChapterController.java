package com.proyectospringsurvey.survey.chapter.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectospringsurvey.survey.chapter.domain.Chapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/")
public class ChapterController {

    @Autowired 
    private ChapterImpService chapterImpService;


    @GetMapping("chapter/{surveyid}")
    public List<Chapter> getAllChapters(@PathVariable Long surveyid) {
        return chapterImpService.getAllChapters(surveyid);
    }

    

    @PostMapping("chapter/{surveyid}")
    public Chapter createChapter(@PathVariable Long surveyid,@RequestBody Chapter chapter) {
        return chapterImpService.createChapter(surveyid,chapter);
        
    }

    @DeleteMapping("chapter/{id}")
    public Chapter deleteChapter(@PathVariable Long id) {
        return chapterImpService.deleteChapterById(id);
    }  
    
}
