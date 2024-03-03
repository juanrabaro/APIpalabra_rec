package com.example.ApiPalabraRec.Repositories;

import com.example.ApiPalabraRec.Models.GameHasWordsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameHasWordsRepository extends JpaRepository<GameHasWordsModel, Integer> {
}
