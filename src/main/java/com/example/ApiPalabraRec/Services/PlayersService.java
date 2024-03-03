package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.PlayersModel;
import com.example.ApiPalabraRec.Models.TeamsModel;
import com.example.ApiPalabraRec.Repositories.IPlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayersService {

    @Autowired
    private IPlayersRepository iPlayersRepository;

    @Autowired
    private TeamsService teamsService;

    public List<PlayersModel> getAllPlayers() {
        return iPlayersRepository.findAll();
    }

    public PlayersModel createPlayer(PlayersModel player) {
        if (player.getTeam() == null) {
            throw new RuntimeException("El equipo del jugador no puede ser nulo");
        }
        PlayersModel existingPlayer = iPlayersRepository.findByUserName(player.getUserName());
        if (existingPlayer != null) {
            throw new RuntimeException("El nombre del jugador ya existe");
        }

        Integer idTeamSeleccionado = player.getTeam().getId_team();
        Optional<TeamsModel> teamSeleccionado = teamsService.getTeamById(idTeamSeleccionado);
        if (teamSeleccionado.isEmpty()) {
            throw new RuntimeException("Ese equipo no existe");
        }

        // Suma el score del nuevo jugador al score actual del equipo
        TeamsModel team = teamSeleccionado.get();
        team.setScore(team.getScore() + player.getScore());

        // Guarda el equipo actualizado
        teamsService.saveTeam(team);

        return iPlayersRepository.save(player);
    }
}
