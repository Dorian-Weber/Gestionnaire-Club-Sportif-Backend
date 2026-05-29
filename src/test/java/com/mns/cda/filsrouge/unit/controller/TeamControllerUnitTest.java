package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.TeamController;
import com.mns.cda.filsrouge.mockService.MockTeamService;
import com.mns.cda.filsrouge.dto.TeamDTO;
import com.mns.cda.filsrouge.model.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TeamControllerUnitTest {

    // GET ALL
    @Test
    public void getTeamList_MustReturnList() {
        TeamController controller = new TeamController(new MockTeamService());

        List<Team> response = controller.getTeamList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }

    // GET TEAM DTO
    @Test
    public void getTeamDTOExist_MustReturnDTO() {
        TeamController controller = new TeamController(new MockTeamService());

        TeamDTO response = controller.getTeamDTO(1);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.idTeam());
    }

    @Test
    public void getTeamDTONotExist_MustThrowException() {
        TeamController controller = new TeamController(new MockTeamService());

        Assertions.assertThrows(RuntimeException.class, () -> controller.getTeamDTO(999));
    }

    // CREATE
    @Test
    public void createTeam_MustReturnCode201() {
        TeamController controller = new TeamController(new MockTeamService());
        Team team = new Team(10, "TestTeam", null, null);

        ResponseEntity<Team> response = controller.create(team);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdTeam());
    }

    // DELETE
    @Test
    public void deleteTeamExist_MustReturnCode204() {
        TeamController controller = new TeamController(new MockTeamService());

        ResponseEntity<Team> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteTeamNotExist_MustReturnCode404() {
        TeamController controller = new TeamController(new MockTeamService());

        ResponseEntity<Team> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateTeamExist_MustReturnCode200() {
        TeamController controller = new TeamController(new MockTeamService());
        Team team = new Team(1, "UpdatedTeam", null, null);

        ResponseEntity<Team> response = controller.update(1, team);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdTeam());
    }

    @Test
    public void updateTeamNotExist_MustReturnCode404() {
        TeamController controller = new TeamController(new MockTeamService());
        Team team = new Team(1, "UpdatedTeam", null, null);

        ResponseEntity<Team> response = controller.update(999, team);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
