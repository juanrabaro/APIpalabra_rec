package com.example.ApiPalabraPruebaTutorial.Services;

import com.example.ApiPalabraPruebaTutorial.Models.TeamsModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.ITeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamsService {

    @Autowired
    private ITeamsRepository iTeamsRepository;

    public List<TeamsModel> getAllTeams() {
        return iTeamsRepository.findAll();
    }
}
