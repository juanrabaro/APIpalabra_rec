package com.example.ApiPalabraPruebaTutorial.Repositories;

import com.example.ApiPalabraPruebaTutorial.Models.GameHasWordsModel;
import com.example.ApiPalabraPruebaTutorial.Models.GameMatchesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameMatchesRepository extends JpaRepository<GameMatchesModel, Integer> {
}
