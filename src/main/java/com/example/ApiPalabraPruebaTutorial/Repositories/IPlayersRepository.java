package com.example.ApiPalabraPruebaTutorial.Repositories;

import com.example.ApiPalabraPruebaTutorial.Models.PlayersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayersRepository extends JpaRepository<PlayersModel, Integer> {
}
