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

        // Suma el score del nuevo jugador al score del equipo
        TeamsModel team = teamSeleccionado.get();
        team.setScore(team.getScore() + player.getScore());

        // Guarda el equipo actualizado
        teamsService.saveTeam(team);

        return iPlayersRepository.save(player);
    }

    public PlayersModel deletePlayer(Integer id) {
        PlayersModel player = iPlayersRepository.findById(id).orElse(null);
        if (player == null) {
            throw new RuntimeException("El jugador no existe");
        }

        // Resta el score del jugador al score del equipo
        TeamsModel team = player.getTeam();
        team.setScore(team.getScore() - player.getScore());

        // Guarda el equipo actualizado
        teamsService.saveTeam(team);

        iPlayersRepository.deleteById(id);
        return player;
    }

    public PlayersModel updatePlayer(PlayersModel player) {
        if (player.getTeam() == null) {
            throw new RuntimeException("El equipo del jugador no puede ser nulo");
        }

        Integer idTeamSeleccionado = player.getTeam().getId_team();
        Optional<TeamsModel> teamSeleccionado = teamsService.getTeamById(idTeamSeleccionado);
        if (teamSeleccionado.isEmpty()) {
            throw new RuntimeException("Ese equipo no existe");
        }

        // Coge el jugador antes del cambio
        PlayersModel playerAntiguo = iPlayersRepository.findById(player.getId_player()).orElse(null);
        if (playerAntiguo == null) {
            throw new RuntimeException("El jugador no existe");
        }

        // Coge el equipo que se va a cambiar antes del cambio
        TeamsModel teamAntiguo = playerAntiguo.getTeam();

        // Selecciona el equipo del jugador a actualizar
        TeamsModel team = teamSeleccionado.get();

        // Hace la operación correspondiente para actualizar el score del equipo
        if ( player.getScore() > playerAntiguo.getScore()) {
            team.setScore(teamAntiguo.getScore() + (player.getScore() - playerAntiguo.getScore()));
        } else if (player.getScore() < playerAntiguo.getScore()) {
            team.setScore(teamAntiguo.getScore() - (playerAntiguo.getScore() - player.getScore()));
        }

        // Guarda el equipo actualizado
        teamsService.saveTeam(team);

        // Guarda el jugador actualizado
        return iPlayersRepository.save(player);
    }
}
