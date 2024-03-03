package com.example.ApiPalabraPruebaTutorial.Services;

import com.example.ApiPalabraPruebaTutorial.Models.GameHasWordsModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.IGameHasWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameHasWordsService {

    @Autowired
    private IGameHasWordsRepository iGameHasWordsRepository;

    public List<GameHasWordsModel> getAllGameHasWords(){
        return iGameHasWordsRepository.findAll();
    }
}
