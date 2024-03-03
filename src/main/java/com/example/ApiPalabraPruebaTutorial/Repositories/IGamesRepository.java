package com.example.ApiPalabraPruebaTutorial.Repositories;

import com.example.ApiPalabraPruebaTutorial.Models.GamesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGamesRepository extends JpaRepository<GamesModel, Integer> {
}
