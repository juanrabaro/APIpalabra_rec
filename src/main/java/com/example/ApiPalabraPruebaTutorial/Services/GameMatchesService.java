package com.example.ApiPalabraPruebaTutorial.Services;

import com.example.ApiPalabraPruebaTutorial.Models.GameMatchesModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.IGameMatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameMatchesService {

    @Autowired
    private IGameMatchesRepository igameMatchesRepository;

    public List<GameMatchesModel> getAllGameMatches() {
        return igameMatchesRepository.findAll();
    }
}
