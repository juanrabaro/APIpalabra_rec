package com.example.ApiPalabraRec.Controllers;

import com.example.ApiPalabraRec.Models.WordsModel;
import com.example.ApiPalabraRec.Services.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/words/random-words/{nWords}")
    public List<WordsModel> getRandomWords(@PathVariable int nWords) {
        return wordsService.getRandomWords(nWords);
    }

    @GetMapping("/words/end-or-begin/{chain}/{nWords}")
    public List<WordsModel> beginOrEndBy(@PathVariable String chain, @PathVariable int nWords) {
        return wordsService.beginOrEndBy(chain, nWords);
    }
}
