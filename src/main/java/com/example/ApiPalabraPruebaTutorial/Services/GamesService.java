package com.example.ApiPalabraPruebaTutorial.Services;

import com.example.ApiPalabraPruebaTutorial.Models.GamesModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.IGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {

    @Autowired
    private IGamesRepository iGamesRepository;

    public List<GamesModel> getAllGames(){
        return iGamesRepository.findAll();
    }
}
