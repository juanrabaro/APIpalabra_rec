package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.WordsModel;
import com.example.ApiPalabraRec.Repositories.IWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsService {

    @Autowired
    private IWordsRepository iWordsRepository;

    public List<WordsModel> getAllWords() {
        return iWordsRepository.findAll();
    }
}
