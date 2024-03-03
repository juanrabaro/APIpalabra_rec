package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.PlayersModel;
import com.example.ApiPalabraRec.Repositories.IPlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PlayersService {

    @Autowired
    private IPlayersRepository iPlayersRepository;

    public List<PlayersModel> getAllPlayers(){
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
        return iPlayersRepository.save(player);
    }
}
