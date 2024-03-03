package com.example.ApiPalabraRec.Models;

/*`id_player` INT NOT NULL AUTO_INCREMENT,
        `user_name` VARCHAR(45) NOT NULL,
        `score` INT NULL DEFAULT 0,
        `avatar_img` VARCHAR(45) NULL,
        `TEAM_id_team` INT NOT NULL,
        PRIMARY KEY (`id_player`, `TEAM_id_team`),
        UNIQUE INDEX `userName_UNIQUE` (`user_name` ASC) VISIBLE,
        INDEX `fk_PLAYER_TEAM_idx` (`TEAM_id_team` ASC) VISIBLE,
        CONSTRAINT `fk_PLAYER_TEAM`
        FOREIGN KEY (`TEAM_id_team`)
        REFERENCES `apiPalabra`.`teams` (`id_team`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION);*/

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;


@Entity
@Table(name = "players")
@Data
public class PlayersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_player;

    @Column(nullable = false, length = 45)
    private String userName;

    @Column(nullable = true, columnDefinition = "INT DEFAULT 0")
    private int score;

    @Column(nullable = true, length = 45)
    private String avatar_img;

    @ManyToOne
    @JoinColumn(name = "TEAM_id_team", nullable = false)
    private TeamsModel team;
}
