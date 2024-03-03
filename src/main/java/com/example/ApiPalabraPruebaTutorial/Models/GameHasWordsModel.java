package com.example.ApiPalabraPruebaTutorial.Models;

/*`GAME_id_game` INT NOT NULL,
        `WORD_id_word` INT NOT NULL,
        `difficulty` VARCHAR(10) NOT NULL,
        PRIMARY KEY (`GAME_id_game`, `WORD_id_word`),
        INDEX `fk_GAME_has_WORD_WORD1_idx` (`WORD_id_word` ASC) VISIBLE,
        INDEX `fk_GAME_has_WORD_GAME1_idx` (`GAME_id_game` ASC) VISIBLE,
        CONSTRAINT `fk_GAME_has_WORD_GAME1`
        FOREIGN KEY (`GAME_id_game`)
        REFERENCES `apiPalabra`.`games` (`id_game`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
        CONSTRAINT `fk_GAME_has_WORD_WORD1`
        FOREIGN KEY (`WORD_id_word`)
        REFERENCES `apiPalabra`.`words` (`id_word`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);*/

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "game_has_words")
@Data
public class GameHasWordsModel {
    @EmbeddedId
    private GameWordKey id;

    @Column(nullable = false, length = 10)
    private String difficulty;

    @MapsId("GAME_id_game")
    @ManyToOne
    @JoinColumn(name = "GAME_id_game")
    private GamesModel game;

    @MapsId("WORD_id_word")
    @ManyToOne
    @JoinColumn(name = "WORD_id_word")
    private WordsModel word;
}
