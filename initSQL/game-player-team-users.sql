/*
CREATE TABLE IF NOT EXISTS `apiPalabra`.`teams` (
  `id_team` INT NOT NULL AUTO_INCREMENT,
  `badge` BLOB NULL,
  `score` INT NULL DEFAULT 0,
  `team_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_team`),
  UNIQUE INDEX `team_name_UNIQUE` (`team_name` ASC) VISIBLE);
*/

insert into teams (team_name, score) values ('team1', 10);
insert into teams (team_name, score) values ('team2', 40);
insert into teams (team_name, score) values ('team3', 15);
insert into teams (team_name, score) values ('team4', 20);

/*
CREATE TABLE IF NOT EXISTS `apiPalabra`.`players` (
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
    REFERENCES `apiPalabra`.`teams` (`id_team`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
*/

insert into players (user_name, TEAM_id_team, score) values ('player1', 1, 10);
insert into players (user_name, TEAM_id_team, score) values ('player2', 2, 40);
insert into players (user_name, TEAM_id_team, score) values ('player3', 3, 15);
insert into players (user_name, TEAM_id_team, score) values ('player4', 4, 20);

/*
CREATE TABLE IF NOT EXISTS `apiPalabra`.`games` (
  `id_game` INT NOT NULL AUTO_INCREMENT,
  `max_tries` INT NULL,
  `description` VARCHAR(72) NULL,
  `difficulty` ENUM('easy', 'normal', 'hard') NOT NULL,
  PRIMARY KEY (`id_game`));
*/

insert into games (max_tries, description, difficulty) values (5, 'easy games', 'easy');
insert into games (max_tries, description, difficulty) values (10, 'normal games', 'normal');
insert into games (max_tries, description, difficulty) values (15, 'hard games', 'hard');

/*
CREATE TABLE IF NOT EXISTS `apiPalabra`.`MATCH` (
  `id_match` INT NOT NULL AUTO_INCREMENT,
  `n_tries` VARCHAR(45) NOT NULL,
  `score` INT NULL DEFAULT 0,
  `dateTime` DATETIME NULL,
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

insert into `apiPalabra`.`game_matches` (`n_tries`, `score`, `dateTime`, `words`, `PLAYER_id_player`, `GAME_id_game`) values ('1', '10', '2020-01-01 00:00:00', 'hola', '1', '1');
insert into `apiPalabra`.`game_matches` (`n_tries`, `score`, `dateTime`, `words`, `PLAYER_id_player`, `GAME_id_game`) values ('2', '20', '2020-01-01 00:00:00', 'hola', '2', '2');
insert into `apiPalabra`.`game_matches` (`n_tries`, `score`, `dateTime`, `words`, `PLAYER_id_player`, `GAME_id_game`) values ('3', '5', '2020-01-01 00:00:00', 'hola', '3', '3');

/*
-- -----------------------------------------------------
-- Table `apiPalabra`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiPalabra`.`users` (
    `id_user` INT NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `email` VARCHAR(70) NULL,
    PRIMARY KEY (`id_user`),
    UNIQUE INDEX `user_namel_UNIQUE` (`user_name` ASC) VISIBLE);
-- -----------------------------------------------------
*/
insert into users (user_name, password, email) values ('admin', 'admin', 'admin@admin.com');
insert into users (user_name, password, email) values ('users', 'users', 'users@users.com');