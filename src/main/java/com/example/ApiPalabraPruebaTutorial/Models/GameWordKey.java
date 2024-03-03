package com.example.ApiPalabraPruebaTutorial.Models;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GameWordKey implements Serializable {

    private int GAME_id_game;
    private int WORD_id_word;

    public int getGAME_id_game() {
        return GAME_id_game;
    }

    public void setGAME_id_game(int GAME_id_game) {
        this.GAME_id_game = GAME_id_game;
    }

    public int getWORD_id_word() {
        return WORD_id_word;
    }

    public void setWORD_id_word(int WORD_id_word) {
        this.WORD_id_word = WORD_id_word;
    }
}
