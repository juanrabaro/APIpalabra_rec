package com.example.ApiPalabraPruebaTutorial.Controllers;


import com.example.ApiPalabraPruebaTutorial.Models.PlayersModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.IPlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayersController {

    @Autowired
    private IPlayersRepository iPlayersRepository;

    @GetMapping("/players")
    public List<PlayersModel> getWords(){
        return iPlayersRepository.findAll();
    }
}
