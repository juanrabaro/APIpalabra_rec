package com.example.ApiPalabraPruebaTutorial.Models;

/*
`id_match` INT NOT NULL AUTO_INCREMENT,
       `n_tries` VARCHAR(45) NOT NULL,
       `score` INT NULL DEFAULT 0,
       `date_time` date_time NULL,
       `words` VARCHAR(45) NOT NULL,
       `PLAYER_id_player` INT NOT NULL,
       `GAME_id_game` INT NOT NULL,
       PRIMARY KEY (`id_match`, `GAME_id_game`),
       INDEX `fk_MATCH_PLAYER1_idx` (`PLAYER_id_player` ASC) VISIBLE,
       INDEX `fk_MATCH_GAME1_idx` (`GAME_id_game` ASC) VISIBLE,
       CONSTRAINT `fk_MATCH_PLAYER1`
       FOREIGN KEY (`PLAYER_id_player`)
       REFERENCES `apiPalabra`.`players` (`id_player`)
       ON DELETE NO ACTION
       ON UPDATE NO ACTION,
       CONSTRAINT `fk_MATCH_GAME1`
       FOREIGN KEY (`GAME_id_game`)
       REFERENCES `apiPalabra`.`games` (`id_game`)
       ON DELETE NO ACTION
       ON UPDATE NO ACTION);

*/

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "game_matches")
@Data
public class GameMatchesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_match;

    @Column(nullable = false, length = 45)
    private String n_tries;

    @Column(nullable = true, columnDefinition = "INT DEFAULT 0")
    private int score;

    @Column(nullable = true)
    private String date_time;

    @Column(nullable = false, length = 45)
    private String words;

    @ManyToOne
    @JoinColumn(name = "PLAYER_id_player")
    private PlayersModel player;

    @ManyToOne
    @JoinColumn(name = "GAME_id_game")
    private GamesModel game;
}
