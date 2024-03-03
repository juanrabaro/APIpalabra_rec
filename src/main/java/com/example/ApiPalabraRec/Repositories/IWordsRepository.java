package com.example.ApiPalabraRec.Repositories;

import com.example.ApiPalabraRec.Models.WordsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWordsRepository extends JpaRepository<WordsModel, Integer> {
}
