package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.TeamController;
import com.mns.cda.filsrouge.mockDAO.MockTeamDao;
import com.mns.cda.filsrouge.model.Athlete;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.model.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TeamControllerUnitTest {

    //Test de GetAll
    @Test
    public void getTeamListAll_MustReturnList() {
        TeamController teamController = new TeamController(new MockTeamDao());

        List<Team> response = teamController.getTeamList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getTeamByIdExist_MustReturnCode200() {

        TeamController teamController = new TeamController(new MockTeamDao());
        ResponseEntity<Team> response = teamController.getTeamById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getTeamByIdNotExist_MustReturnCode404() {

        TeamController teamController = new TeamController(new MockTeamDao());
        ResponseEntity<Team> response = teamController.getTeamById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createTeam_MustReturnCode201() {
        TeamController teamController = new TeamController(new MockTeamDao());
        Team team = new Team(1,
                "Test",
                List.of(new Event()),
                List.of(new Athlete()));

        ResponseEntity<Team> response = teamController.create(team);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdTeam());
    }

    // Test de Delete
    @Test
    public void deleteTeamExist_MustReturnCode204() {
        TeamController teamController = new TeamController(new MockTeamDao());

        ResponseEntity<Team> response = teamController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteTeamNotExist_MustReturnCode404() {
        TeamController teamController = new TeamController(new MockTeamDao());

        ResponseEntity<Team> response = teamController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateTeam_MustReturnCode200() {
        TeamController teamController = new TeamController(new MockTeamDao());
        Team team = new Team(1,
                "Test",
                List.of(new Event()),
                List.of(new Athlete()));

        ResponseEntity<Team> response = teamController.update(1, team);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdTeam());
    }

    @Test
    public void updateTeamNotExist_MustReturnCode404() {
        TeamController teamController = new TeamController(new MockTeamDao());
        Team team = new Team(1,
                "Test",
                List.of(new Event()),
                List.of(new Athlete()));

        ResponseEntity<Team> reponse = teamController.update(2, team);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
