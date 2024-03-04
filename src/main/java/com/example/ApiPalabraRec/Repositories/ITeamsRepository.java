package com.example.ApiPalabraRec.Repositories;

import com.example.ApiPalabraRec.Models.TeamsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamsRepository extends JpaRepository<TeamsModel, Integer> {
    TeamsModel findByTeamName(String teamName);
}
