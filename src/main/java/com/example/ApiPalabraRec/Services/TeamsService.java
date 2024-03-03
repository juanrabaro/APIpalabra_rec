package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.TeamsModel;
import com.example.ApiPalabraRec.Repositories.ITeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamsService {

    @Autowired
    private ITeamsRepository iTeamsRepository;

    public List<TeamsModel> getAllTeams() {
        return iTeamsRepository.findAll();
    }

    public Optional<TeamsModel> getTeamById(Integer id) {
        return iTeamsRepository.findById(id);
    }

    public TeamsModel saveTeam(TeamsModel team) {
        return iTeamsRepository.save(team);
    }
}
