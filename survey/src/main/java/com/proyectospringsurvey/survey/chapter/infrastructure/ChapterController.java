package com.proyectospringsurvey.survey.chapter.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectospringsurvey.survey.chapter.domain.Chapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/chapter/")
public class ChapterController {

    @Autowired 
    private ChapterImpService chapterImpService;


    @GetMapping("")
    public List<Chapter> getAllChapters(@RequestParam String param) {
        return chapterImpService.getAllChapters();
    }

    

    @PostMapping("")
    public Chapter createChapter(@RequestBody Chapter chapter) {
        return chapterImpService.createChapter(chapter);
        
    }


    @DeleteMapping("{id}")
    public Chapter deleteChapter(@PathVariable Long id) {
        return chapterImpService.deleteChapterById(id);
    }  
    
}
