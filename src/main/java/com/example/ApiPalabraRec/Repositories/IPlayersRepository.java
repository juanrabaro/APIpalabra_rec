package com.example.ApiPalabraRec.Repositories;

import com.example.ApiPalabraRec.Models.PlayersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayersRepository extends JpaRepository<PlayersModel, Integer> {
}
