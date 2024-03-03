package com.example.ApiPalabraPruebaTutorial.Controllers;

import com.example.ApiPalabraPruebaTutorial.Models.TeamsModel;
import com.example.ApiPalabraPruebaTutorial.Repositories.ITeamsRepository;
import com.example.ApiPalabraPruebaTutorial.Services.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamsController {

    @Autowired
    private TeamsService teamsService;

    @GetMapping("/teams")
    public List<TeamsModel> getAllTeams() {
        return teamsService.getAllTeams();
    }
}
