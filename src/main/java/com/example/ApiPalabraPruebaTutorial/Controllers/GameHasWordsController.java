package com.example.ApiPalabraPruebaTutorial.Controllers;

import com.example.ApiPalabraPruebaTutorial.Models.GameHasWordsModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.IGameHasWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameHasWordsController {

    @Autowired
    private IGameHasWordsRepository iGameHasWordsRepository;

    @GetMapping("/game-has-words")
    public List<GameHasWordsModel> getGameHasWords() {
        return iGameHasWordsRepository.findAll();
    }
}
