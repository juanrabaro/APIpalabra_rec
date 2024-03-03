package com.example.ApiPalabraPruebaTutorial.Models;

/*`id_team` INT NOT NULL AUTO_INCREMENT,
        `badge` VARCHAR(45) NULL,
        `score` INT NULL DEFAULT 0,
        `team_name` VARCHAR(45) NOT NULL,
        PRIMARY KEY (`id_team`),
        UNIQUE INDEX `team_name_UNIQUE` (`team_name` ASC) VISIBLE);*/

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "teams")
@Data
public class TeamsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_team;

    @Column(nullable = true, length = 45)
    private String badge;

    @Column(nullable = true, columnDefinition = "INT DEFAULT 0")
    private int score;

    @Column(nullable = false, length = 45)
    private String team_name;

    /*@OneToMany
    private List<PlayersModel> players;*/
}
