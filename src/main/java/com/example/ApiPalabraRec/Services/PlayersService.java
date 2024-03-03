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

    public PlayersModel createPlayer(@RequestBody PlayersModel player) {
        Optional<PlayersModel> playerExist = iPlayersRepository.findById(player.getId_player());
        if ( playerExist.isPresent() ) {

        } else {
            return iPlayersRepository.save(player);
        }
    }
}
