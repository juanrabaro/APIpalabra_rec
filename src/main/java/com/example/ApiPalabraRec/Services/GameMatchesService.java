package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.GameMatchesModel;
import com.example.ApiPalabraRec.Repositories.IGameMatchesRepository;
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
