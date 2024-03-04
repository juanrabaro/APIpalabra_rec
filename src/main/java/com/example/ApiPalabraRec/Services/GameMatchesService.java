package com.example.ApiPalabraRec.Services;

import com.example.ApiPalabraRec.Models.GameMatchesModel;
import com.example.ApiPalabraRec.Models.GamesModel;
import com.example.ApiPalabraRec.Models.PlayersModel;
import com.example.ApiPalabraRec.Repositories.IGameMatchesRepository;
import com.example.ApiPalabraRec.Repositories.IGamesRepository;
import com.example.ApiPalabraRec.Repositories.IPlayersRepository;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameMatchesService {

    @Autowired
    private IGameMatchesRepository igameMatchesRepository;

    @Autowired
    private IGamesRepository igamesRepository;

    @Autowired
    private IPlayersRepository iplayersRepository;

    public List<GameMatchesModel> getAllGameMatches() {
        return igameMatchesRepository.findAll();
    }

    public GameMatchesModel createGameMatch(GameMatchesModel gameMatch) {
        if (gameMatch.getGame() == null) {
            throw new RuntimeException("El juego del match no puede ser nulo");
        }
        GamesModel existingGame = igamesRepository.findById(gameMatch.getGame().getId_game()).orElse(null);
        if (existingGame == null) {
            throw new RuntimeException("El juego no existe");
        }

        if (gameMatch.getPlayer() == null) {
            throw new RuntimeException("El jugador no puede ser nulo");
        }
        PlayersModel existingPlayer = iplayersRepository.findById(gameMatch.getPlayer().getId_player()).orElse(null);
        if (existingPlayer == null) {
            throw new RuntimeException("El jugador no existe");
        }

        return igameMatchesRepository.save(gameMatch);
    }

    public String deleteGameMatch(Integer id) {
        GameMatchesModel gameMatch = igameMatchesRepository.findById(id).orElse(null);
        if (gameMatch == null) {
            throw new RuntimeException("El match no existe");
        }
        igameMatchesRepository.deleteById(id);
        return "El game match con el id " + id +" ha sido eliminado";
    }

    public GameMatchesModel updateGameMatch(GameMatchesModel gameMatch) {
        System.out.println(gameMatch);
        GameMatchesModel existingGameMatch = igameMatchesRepository.findById(gameMatch.getId_match()).orElse(null);
        if (existingGameMatch == null) {
            throw new RuntimeException("El match no existe");
        }
        return igameMatchesRepository.save(gameMatch);
    }
}
