package com.example.ApiPalabraPruebaTutorial.Repositories;

import com.example.ApiPalabraPruebaTutorial.Models.WordsModel;
import org.springframework.data.repository.CrudRepository;

public interface IWordsRepository extends CrudRepository<WordsModel, Integer>{
}
