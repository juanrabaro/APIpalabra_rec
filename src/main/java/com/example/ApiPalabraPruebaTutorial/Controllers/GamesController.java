package com.example.ApiPalabraPruebaTutorial.Controllers;

import com.example.ApiPalabraPruebaTutorial.Models.GamesModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.IGamesRepository;
import com.example.ApiPalabraPruebaTutorial.Services.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GamesController {

    @Autowired
    private GamesService gamesService;

    @GetMapping("/games")
    public List<GamesModel> getAllGames(){
        return gamesService.getAllGames();
    }
}
