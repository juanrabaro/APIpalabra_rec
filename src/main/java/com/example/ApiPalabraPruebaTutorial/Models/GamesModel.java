package com.example.ApiPalabraPruebaTutorial.Models;

/*`id_game` INT NOT NULL AUTO_INCREMENT,
        `max_tries` INT NULL,
        `description` VARCHAR(72) NULL,
        `difficulty` VARCHAR(10) NOT NULL,
        PRIMARY KEY (`id_game`));*/

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "games")
@Data
public class GamesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_game;

    @Column(nullable = true)
    private int max_tries;

    @Column(nullable = true, length = 72)
    private String description;

    @Column(nullable = false, length = 10)
    private String difficulty;
}
