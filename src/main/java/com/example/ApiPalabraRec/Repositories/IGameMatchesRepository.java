package com.example.ApiPalabraRec.Repositories;

import com.example.ApiPalabraRec.Models.GameMatchesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameMatchesRepository extends JpaRepository<GameMatchesModel, Integer> {
}
