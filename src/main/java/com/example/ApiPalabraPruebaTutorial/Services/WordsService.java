package com.example.ApiPalabraPruebaTutorial.Services;

import com.example.ApiPalabraPruebaTutorial.Models.WordsModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.IWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsService {

    @Autowired
    private IWordsRepository iWordsRepository;

    public List<WordsModel> getWords() {
        return iWordsRepository.findAll();
    }
}
