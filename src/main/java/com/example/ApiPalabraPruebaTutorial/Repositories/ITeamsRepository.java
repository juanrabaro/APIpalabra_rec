package com.example.ApiPalabraPruebaTutorial.Repositories;

import com.example.ApiPalabraPruebaTutorial.Models.TeamsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamsRepository extends JpaRepository<TeamsModel, Integer> {
}
