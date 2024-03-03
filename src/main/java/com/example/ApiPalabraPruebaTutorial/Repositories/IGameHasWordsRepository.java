package com.example.ApiPalabraPruebaTutorial.Repositories;

import com.example.ApiPalabraPruebaTutorial.Models.GameHasWordsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameHasWordsRepository extends JpaRepository<GameHasWordsModel, Integer> {
}
