package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.GameMatchesModel;
import com.example.ApiPalabraRec.Models.PlayersModel;
import com.example.ApiPalabraRec.Models.TeamsModel;
import com.example.ApiPalabraRec.Repositories.IGameMatchesRepository;
import com.example.ApiPalabraRec.Repositories.IPlayersRepository;
import com.example.ApiPalabraRec.Repositories.ITeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamsService {

    @Autowired
    private ITeamsRepository iTeamsRepository;

    @Autowired
    private IPlayersRepository iPlayersRepository;

    @Autowired
    private IGameMatchesRepository iGameMatchesRepository;


    public List<TeamsModel> getAllTeams() {
        return iTeamsRepository.findAll();
    }

    public Optional<TeamsModel> getTeamById(Integer id) {
        return iTeamsRepository.findById(id);
    }

    public TeamsModel saveTeam(TeamsModel team) {
        return iTeamsRepository.save(team);
    }

    public String deleteTeam(Integer id) {
        TeamsModel team = iTeamsRepository.findById(id).orElse(null);
        if (team == null) {
            throw new RuntimeException("El equipo no existe");
        }

        List<GameMatchesModel> gameMatches = iGameMatchesRepository.findAll();
        for (GameMatchesModel gameMatch : gameMatches) {
            if (gameMatch.getPlayer().getId_player() == id) {
                iGameMatchesRepository.deleteById(gameMatch.getId_match());
            }
        }

        List<PlayersModel> players = iPlayersRepository.findAll();
        for (PlayersModel player : players) {
            if (player.getTeam().getId_team() == id) {
                iPlayersRepository.deleteById(player.getId_player());
            }
        }

        iTeamsRepository.deleteById(id);
        return "Equipo con id " + id + " eliminado";
    }

    public TeamsModel updateTeam(TeamsModel team) {
        TeamsModel existingTeam = iTeamsRepository.findById(team.getId_team()).orElse(null);
        if (existingTeam == null) {
            throw new RuntimeException("El equipo no existe");
        }
        return iTeamsRepository.save(team);
    }
}
