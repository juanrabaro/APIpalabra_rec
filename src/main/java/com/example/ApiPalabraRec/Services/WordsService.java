package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.WordsModel;
import com.example.ApiPalabraRec.Repositories.IWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WordsService {

    @Autowired
    private IWordsRepository iWordsRepository;

    public List<WordsModel> getAllWords() {
        return iWordsRepository.findAll();
    }

    public List<WordsModel> getRandomWords(int nWords) {
        List<WordsModel> allWords = iWordsRepository.findAll();

        Collections.shuffle(allWords);

        return allWords.subList(0, Math.min(nWords, allWords.size()));
    }
}
