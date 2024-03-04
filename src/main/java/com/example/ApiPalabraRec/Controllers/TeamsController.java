package com.example.ApiPalabraRec.Controllers;

import com.example.ApiPalabraRec.Models.TeamsModel;
import com.example.ApiPalabraRec.Services.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/teams")
    public TeamsModel updateTeam(@RequestBody TeamsModel team) {
        return teamsService.updateTeam(team);
    }

    @DeleteMapping("/teams/{id}")
    public String deleteTeam(@PathVariable Integer id) {
        return teamsService.deleteTeam(id);
    }
}
