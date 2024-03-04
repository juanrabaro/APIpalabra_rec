package com.example.ApiPalabraRec;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiPalabraRecTests {

	@Autowired
	private TestRestTemplate restTemplate;

	private String baseUrl;

	@BeforeEach
	public void setUp() {
		baseUrl = "http://localhost:" + 8081 + "/api";
	}

	@Test
	@Transactional
	void testGetWordsEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/words", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Transactional
	void testGetPlayersEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/players", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Transactional
	void testGetTeamsEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/teams", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Transactional
	void testGetGamesEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/games", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Transactional
	void testGetGameMatchesEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/game-matches", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	/*@Test
	@Transactional
	void testNewPlayerEndpoint() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String requestBody = "{\r\n    \"userName\": \"antonio\",\r\n    \"score\": 15,\r\n    \"team\": {\r\n        \"id_team\": 2\r\n    }\r\n}";
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(baseUrl + "/players", requestEntity, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}


	@Test
	@Transactional
	void testNewTeamEndpoint() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String requestBody = "{\r\n    \"teamName\": \"equipoNuevo\"\r\n}";
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(baseUrl + "/players", requestEntity, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Transactional
	void testNewGameMatchEndpoint() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String requestBody = "{\r\n  \"n_tries\": \"7\",\r\n  \"score\": 30,\r\n  \"words\": \"palabraPruebaPost\",\r\n  \"player\": {\r\n    \"id_player\": 2\r\n  },\r\n  \"game\": {\r\n    \"id_game\": 2\r\n  }\r\n}";
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(baseUrl + "/players", requestEntity, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}*/

	@Test
	@Transactional
	void testEditPlayerEndpoint() {
		String requestBody = "{\r\n    \"id_player\": 1,\r\n    \"userName\": \"juan\",\r\n    \"score\": 20,\r\n    \"team\": {\r\n        \"id_team\": 1\r\n    }\r\n}";
		restTemplate.put(baseUrl + "/players", requestBody);
	}

	@Test
	@Transactional
	void testEditTeamEndpoint() {
		String requestBody = "{\r\n    \"id_team\": 2,\r\n    \"score\": 80,\r\n    \"team_name\": \"equipo2remix\"\r\n}";
		restTemplate.put(baseUrl + "/teams", requestBody);
	}

	@Test
	@Transactional
	void testEditGameMatchEndpoint() {
		String requestBody = "{\r\n  \"id_match\": 5,\r\n  \"n_tries\": \"77\",\r\n  \"score\": 70,\r\n  \"words\": \"palabraPruebaPostEdit\",\r\n  \"player\": {\r\n    \"id_player\": 3\r\n  },\r\n  \"game\": {\r\n    \"id_game\": 1\r\n  }\r\n}";
		restTemplate.put(baseUrl + "/game-matches", requestBody);
	}

	@Test
	@Transactional
	void testDeletePlayerEndpoint() {
		restTemplate.delete(baseUrl + "/players/3");
	}

	@Test
	@Transactional
	void testDeleteTeamEndpoint() {
		restTemplate.delete(baseUrl + "/teams/1");
	}

	@Test
	@Transactional
	void testDeleteGameMatchEndpoint() {
		restTemplate.delete(baseUrl + "/game-matches/4");
	}

	@Test
	@Transactional
	void testGetRandomWordsEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/words/random-words/10", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Transactional
	void testGetWordsEndOrBeginWithEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/words/end-or-begin/verde/10", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Transactional
	void testGetWordsContainsEndpoint() {
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/words/contains/verde/10", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
