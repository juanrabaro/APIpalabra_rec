-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql
-- Tiempo de generación: 04-03-2024 a las 11:28:51
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `apiPalabra`
--
CREATE DATABASE IF NOT EXISTS `apiPalabra` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `apiPalabra`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `games`
--

CREATE TABLE `games` (
  `id_game` int NOT NULL,
  `max_tries` int DEFAULT NULL,
  `description` varchar(72) DEFAULT NULL,
  `difficulty` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `game_matches`
--

CREATE TABLE `game_matches` (
  `id_match` int NOT NULL,
  `n_tries` varchar(45) NOT NULL,
  `score` int DEFAULT '0',
  `date_time` date DEFAULT NULL,
  `words` varchar(45) NOT NULL,
  `PLAYER_id_player` int NOT NULL,
  `GAME_id_game` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `players`
--

CREATE TABLE `players` (
  `id_player` int NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `score` int DEFAULT '0',
  `avatar_img` varchar(45) DEFAULT NULL,
  `TEAM_id_team` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teams`
--

CREATE TABLE `teams` (
  `id_team` int NOT NULL,
  `badge` varchar(45) DEFAULT NULL,
  `score` int DEFAULT '0',
  `team_name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words`
--

CREATE TABLE `words` (
  `id_word` int NOT NULL,
  `words` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`id_game`);

--
-- Indices de la tabla `game_matches`
--
ALTER TABLE `game_matches`
  ADD PRIMARY KEY (`id_match`,`GAME_id_game`),
  ADD KEY `fk_MATCH_PLAYER1_idx` (`PLAYER_id_player`),
  ADD KEY `fk_MATCH_GAME1_idx` (`GAME_id_game`);

--
-- Indices de la tabla `players`
--
ALTER TABLE `players`
  ADD PRIMARY KEY (`id_player`,`TEAM_id_team`),
  ADD UNIQUE KEY `userName_UNIQUE` (`user_name`),
  ADD KEY `fk_PLAYER_TEAM_idx` (`TEAM_id_team`);

--
-- Indices de la tabla `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`id_team`),
  ADD UNIQUE KEY `team_name_UNIQUE` (`team_name`);

--
-- Indices de la tabla `words`
--
ALTER TABLE `words`
  ADD PRIMARY KEY (`id_word`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `games`
--
ALTER TABLE `games`
  MODIFY `id_game` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `game_matches`
--
ALTER TABLE `game_matches`
  MODIFY `id_match` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `players`
--
ALTER TABLE `players`
  MODIFY `id_player` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `teams`
--
ALTER TABLE `teams`
  MODIFY `id_team` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `words`
--
ALTER TABLE `words`
  MODIFY `id_word` int NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `game_matches`
--
ALTER TABLE `game_matches`
  ADD CONSTRAINT `fk_MATCH_GAME1` FOREIGN KEY (`GAME_id_game`) REFERENCES `games` (`id_game`),
  ADD CONSTRAINT `fk_MATCH_PLAYER1` FOREIGN KEY (`PLAYER_id_player`) REFERENCES `players` (`id_player`);

--
-- Filtros para la tabla `players`
--
ALTER TABLE `players`
  ADD CONSTRAINT `fk_PLAYER_TEAM` FOREIGN KEY (`TEAM_id_team`) REFERENCES `teams` (`id_team`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
