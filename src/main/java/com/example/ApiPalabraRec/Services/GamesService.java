package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.GamesModel;
import com.example.ApiPalabraRec.Repositories.IGamesRepository;
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
