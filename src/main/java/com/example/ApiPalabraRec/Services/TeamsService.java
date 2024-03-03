package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.TeamsModel;
import com.example.ApiPalabraRec.Repositories.ITeamsRepository;
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
