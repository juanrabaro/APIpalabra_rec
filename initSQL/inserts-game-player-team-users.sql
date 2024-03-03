insert into teams (team_name, score) values ('team1', 10);
insert into teams (team_name, score) values ('team2', 20);
insert into teams (team_name, score) values ('team3', 30);
insert into teams (team_name, score) values ('team4', 40);

insert into players (user_name, TEAM_id_team, score) values ('player1', 1, 10);
insert into players (user_name, TEAM_id_team, score) values ('player2', 2, 20);
insert into players (user_name, TEAM_id_team, score) values ('player3', 3, 30);
insert into players (user_name, TEAM_id_team, score) values ('player4', 4, 40);

insert into games (max_tries, description, difficulty) values (5, '5 tries easy game', 'easy');
insert into games (max_tries, description, difficulty) values (10, '10 tries normal game', 'normal');
insert into games (max_tries, description, difficulty) values (15, '15 tries hard game', 'hard');

insert into `apiPalabra`.`game_matches` (`n_tries`, `score`, `dateTime`, `words`, `PLAYER_id_player`, `GAME_id_game`) values ('1', '10', '2020-01-01 00:00:00', 'palabra1', '1', '1');
insert into `apiPalabra`.`game_matches` (`n_tries`, `score`, `dateTime`, `words`, `PLAYER_id_player`, `GAME_id_game`) values ('2', '15', '2020-01-01 00:00:00', 'palabra2', '2', '2');
insert into `apiPalabra`.`game_matches` (`n_tries`, `score`, `dateTime`, `words`, `PLAYER_id_player`, `GAME_id_game`) values ('3', '20', '2020-01-01 00:00:00', 'palabra3', '3', '3');

insert into users (user_name, password, email) values ('admin', 'admin', 'admin@admin.com');
insert into users (user_name, password, email) values ('users', 'users', 'users@users.com');