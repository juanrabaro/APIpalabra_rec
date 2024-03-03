package com.example.ApiPalabraPruebaTutorial.Services;

import com.example.ApiPalabraPruebaTutorial.Models.PlayersModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.IPlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersService {

    @Autowired
    private IPlayersRepository playersRepository;

    public List<PlayersModel> getAllPlayers(){
        return playersRepository.findAll();
    }
}
