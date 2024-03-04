package com.example.ApiPalabraRec.Controllers;

import com.example.ApiPalabraRec.Models.GameMatchesModel;
import com.example.ApiPalabraRec.Services.GameMatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/game-matches")
    public GameMatchesModel createGameMatch(@RequestBody GameMatchesModel gameMatch) {
        return gameMatchesService.createGameMatch(gameMatch);
    }

    @DeleteMapping("/game-matches/{id}")
    public String deleteGameMatch(@PathVariable Integer id) {
        return gameMatchesService.deleteGameMatch(id);
    }
}
