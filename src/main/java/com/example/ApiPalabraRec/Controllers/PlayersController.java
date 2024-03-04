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

    @PutMapping("/players")
    public PlayersModel updatePlayer(@RequestBody PlayersModel player){
        return playersService.updatePlayer(player);
    }

    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable Integer id){
        playersService.deletePlayer(id);
        return "Jugador con id " + id + " eliminado";
    }

}
