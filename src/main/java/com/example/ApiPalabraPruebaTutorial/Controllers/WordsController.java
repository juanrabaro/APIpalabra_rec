package com.example.ApiPalabraPruebaTutorial.Controllers;

import com.example.ApiPalabraPruebaTutorial.Models.WordsModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.IWordsRepository;
import com.example.ApiPalabraPruebaTutorial.Services.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WordsController {

    @Autowired
    private WordsService wordsService;

    @GetMapping("/words")
    public List<WordsModel> getAllWords() {
        return wordsService.getAllWords();
    }
}
