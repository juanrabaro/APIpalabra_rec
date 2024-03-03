package com.example.ApiPalabraRec.Controllers;


import com.example.ApiPalabraRec.Models.PlayersModel;
import com.example.ApiPalabraRec.Services.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
