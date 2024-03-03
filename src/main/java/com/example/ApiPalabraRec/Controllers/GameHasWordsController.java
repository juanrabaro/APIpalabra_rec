package com.example.ApiPalabraRec.Controllers;

import com.example.ApiPalabraRec.Models.GameHasWordsModel;
import com.example.ApiPalabraRec.Services.GameHasWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameHasWordsController {

    @Autowired
    private GameHasWordsService gameHasWordsService;

    @GetMapping("/game-has-words")
    public List<GameHasWordsModel> getGameHasWords() {
        return gameHasWordsService.getAllGameHasWords();
    }
}
