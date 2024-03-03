package com.example.ApiPalabraPruebaTutorial.Repositories;

import com.example.ApiPalabraPruebaTutorial.Models.WordsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWordsRepository extends JpaRepository<WordsModel, Integer> {
}
