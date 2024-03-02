-- MySQL Script generated by MySQL Workbench
-- Wed Dec 13 13:26:12 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema apiPalabra
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema apiPalabra
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `apiPalabra` ;
USE `apiPalabra` ;

-- -----------------------------------------------------
-- Table `apiPalabra`.`TEAM`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiPalabra`.`TEAM` (
                                                     `id_team` INT NOT NULL AUTO_INCREMENT,
                                                     `badge` BLOB NULL,
                                                     `score` INT NULL DEFAULT 0,
                                                     `team_name` VARCHAR(45) NOT NULL,
                                                     PRIMARY KEY (`id_team`),
                                                     UNIQUE INDEX `team_name_UNIQUE` (`team_name` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `apiPalabra`.`PLAYER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiPalabra`.`PLAYER` (
                                                       `id_player` INT NOT NULL AUTO_INCREMENT,
                                                       `user_name` VARCHAR(45) NOT NULL,
                                                       `score` INT NULL DEFAULT 0,
                                                       `avatar_img` BLOB NULL,
                                                       `TEAM_id_team` INT NOT NULL,
                                                       PRIMARY KEY (`id_player`, `TEAM_id_team`),
                                                       UNIQUE INDEX `userName_UNIQUE` (`user_name` ASC) VISIBLE,
                                                       INDEX `fk_PLAYER_TEAM_idx` (`TEAM_id_team` ASC) VISIBLE,
                                                       CONSTRAINT `fk_PLAYER_TEAM`
                                                           FOREIGN KEY (`TEAM_id_team`)
                                                               REFERENCES `apiPalabra`.`TEAM` (`id_team`)
                                                               ON DELETE NO ACTION
                                                               ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `apiPalabra`.`GAME`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiPalabra`.`GAME` (
                                                     `id_game` INT NOT NULL AUTO_INCREMENT,
                                                     `max_tries` INT NULL,
                                                     `description` VARCHAR(72) NULL,
                                                     `difficulty` ENUM('easy', 'normal', 'hard') NOT NULL,
                                                     PRIMARY KEY (`id_game`));


-- -----------------------------------------------------
-- Table `apiPalabra`.`GAME_MATCH`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiPalabra`.`GAME_MATCH` (
                                                           `id_match` INT NOT NULL AUTO_INCREMENT,
                                                           `n_tries` VARCHAR(45) NOT NULL,
                                                           `score` INT NULL DEFAULT 0,
                                                           `dateTime` DATETIME NULL,
                                                           `word` VARCHAR(45) NOT NULL,
                                                           `PLAYER_id_player` INT NOT NULL,
                                                           `GAME_id_game` INT NOT NULL,
                                                           PRIMARY KEY (`id_match`, `GAME_id_game`),
                                                           INDEX `fk_MATCH_PLAYER1_idx` (`PLAYER_id_player` ASC) VISIBLE,
                                                           INDEX `fk_MATCH_GAME1_idx` (`GAME_id_game` ASC) VISIBLE,
                                                           CONSTRAINT `fk_MATCH_PLAYER1`
                                                               FOREIGN KEY (`PLAYER_id_player`)
                                                                   REFERENCES `apiPalabra`.`PLAYER` (`id_player`)
                                                                   ON DELETE NO ACTION
                                                                   ON UPDATE NO ACTION,
                                                           CONSTRAINT `fk_MATCH_GAME1`
                                                               FOREIGN KEY (`GAME_id_game`)
                                                                   REFERENCES `apiPalabra`.`GAME` (`id_game`)
                                                                   ON DELETE NO ACTION
                                                                   ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `apiPalabra`.`WORD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiPalabra`.`WORD` (
                                                     `id_word` INT NOT NULL AUTO_INCREMENT,
                                                     `word` VARCHAR(45) NOT NULL,
                                                     PRIMARY KEY (`id_word`));


-- -----------------------------------------------------
-- Table `apiPalabra`.`GAME_has_WORD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiPalabra`.`GAME_has_WORD` (
                                                              `GAME_id_game` INT NOT NULL,
                                                              `WORD_id_word` INT NOT NULL,
                                                              `difficulty` ENUM('easy', 'normal', 'hard') NOT NULL,
                                                              PRIMARY KEY (`GAME_id_game`, `WORD_id_word`),
                                                              INDEX `fk_GAME_has_WORD_WORD1_idx` (`WORD_id_word` ASC) VISIBLE,
                                                              INDEX `fk_GAME_has_WORD_GAME1_idx` (`GAME_id_game` ASC) VISIBLE,
                                                              CONSTRAINT `fk_GAME_has_WORD_GAME1`
                                                                  FOREIGN KEY (`GAME_id_game`)
                                                                      REFERENCES `apiPalabra`.`GAME` (`id_game`)
                                                                      ON DELETE NO ACTION
                                                                      ON UPDATE NO ACTION,
                                                              CONSTRAINT `fk_GAME_has_WORD_WORD1`
                                                                  FOREIGN KEY (`WORD_id_word`)
                                                                      REFERENCES `apiPalabra`.`WORD` (`id_word`)
                                                                      ON DELETE NO ACTION
                                                                      ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `apiPalabra`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiPalabra`.`USER` (
                                                     `id_user` INT NOT NULL AUTO_INCREMENT,
                                                     `user_name` VARCHAR(45) NOT NULL,
                                                     `password` VARCHAR(45) NOT NULL,
                                                     `email` VARCHAR(70) NULL,
                                                     PRIMARY KEY (`id_user`),
                                                     UNIQUE INDEX `user_namel_UNIQUE` (`user_name` ASC) VISIBLE);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
