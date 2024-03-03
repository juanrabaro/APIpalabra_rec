package com.example.ApiPalabraRec.Controllers;

import com.example.ApiPalabraRec.Models.GameMatchesModel;
import com.example.ApiPalabraRec.Services.GameMatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameMatchesController {

    @Autowired
    private GameMatchesService gameMatchesService;

    @GetMapping("/game-matches")
    public List<GameMatchesModel> getGameMatches() {
        return gameMatchesService.getAllGameMatches();
    }
}
