
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `apiPalabra` ;
USE `apiPalabra` ;

CREATE TABLE IF NOT EXISTS `apiPalabra`.`teams` (
                                                     `id_team` INT NOT NULL AUTO_INCREMENT,
                                                     `badge` VARCHAR(45) NULL,
                                                     `score` INT NULL DEFAULT 0,
                                                     `team_name` VARCHAR(45) NOT NULL,
                                                     PRIMARY KEY (`id_team`),
                                                     UNIQUE INDEX `team_name_UNIQUE` (`team_name` ASC) VISIBLE);

CREATE TABLE IF NOT EXISTS `apiPalabra`.`players` (
                                                       `id_player` INT NOT NULL AUTO_INCREMENT,
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
                                                               ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `apiPalabra`.`games` (
                                                     `id_game` INT NOT NULL AUTO_INCREMENT,
                                                     `max_tries` INT NULL,
                                                     `description` VARCHAR(72) NULL,
                                                     `difficulty` VARCHAR(10) NOT NULL,
                                                     PRIMARY KEY (`id_game`));

CREATE TABLE IF NOT EXISTS `apiPalabra`.`game_matches` (
                                                           `id_match` INT NOT NULL AUTO_INCREMENT,
                                                           `n_tries` VARCHAR(45) NOT NULL,
                                                           `score` INT NULL DEFAULT 0,
                                                           `date_time` DATE NULL,
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

CREATE TABLE IF NOT EXISTS `apiPalabra`.`words` (
                                                     `id_word` INT NOT NULL AUTO_INCREMENT,
                                                     `words` VARCHAR(45) NOT NULL,
                                                     PRIMARY KEY (`id_word`));

CREATE TABLE IF NOT EXISTS `apiPalabra`.`game_has_words` (
                                                              `GAME_id_game` INT NOT NULL,
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
                                                                      ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `apiPalabra`.`users` (
                                                     `id_user` INT NOT NULL AUTO_INCREMENT,
                                                     `user_name` VARCHAR(45) NOT NULL,
                                                     `password` VARCHAR(45) NOT NULL,
                                                     `email` VARCHAR(70) NULL,
                                                     PRIMARY KEY (`id_user`),
                                                     UNIQUE INDEX `user_namel_UNIQUE` (`user_name` ASC) VISIBLE);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
