package com.example.ApiPalabraRec.Repositories;

import com.example.ApiPalabraRec.Models.GamesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGamesRepository extends JpaRepository<GamesModel, Integer> {
}
