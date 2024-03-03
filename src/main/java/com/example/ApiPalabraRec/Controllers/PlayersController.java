package com.example.ApiPalabraRec.Controllers;


import com.example.ApiPalabraRec.Models.PlayersModel;
import com.example.ApiPalabraRec.Services.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayersController {

    @Autowired
    private PlayersService playersService;

    @GetMapping("/players")
    public List<PlayersModel> getAllPlayers(){
        return playersService.getAllPlayers();
    }

    @PostMapping("/players")
    public PlayersModel savePlayer(@RequestBody PlayersModel player){
        return playersService.createPlayer(player);
    }
}
