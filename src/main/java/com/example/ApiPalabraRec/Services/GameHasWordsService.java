package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.GameHasWordsModel;
import com.example.ApiPalabraRec.Repositories.IGameHasWordsRepository;
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
