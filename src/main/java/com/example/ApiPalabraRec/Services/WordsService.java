package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.WordsModel;
import com.example.ApiPalabraRec.Repositories.IWordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<WordsModel> beginOrEndBy(String chain, int nWords) {
        List<WordsModel> allWords = iWordsRepository.findAll();

        List<WordsModel> filteredWords = allWords.stream()
        .filter(word -> word.getWords().startsWith(chain) || word.getWords().endsWith(chain))
        .collect(Collectors.toList());

        return filteredWords.subList(0, Math.min(nWords, filteredWords.size()));
    }

    public List<WordsModel> containsChain(String chain, int nWords) {
        List<WordsModel> allWords = iWordsRepository.findAll();

        List<WordsModel> filteredWords = allWords.stream()
                .filter(word -> word.getWords().contains(chain))
                .collect(Collectors.toList());

        return filteredWords.subList(0, Math.min(nWords, filteredWords.size()));
    }
}
