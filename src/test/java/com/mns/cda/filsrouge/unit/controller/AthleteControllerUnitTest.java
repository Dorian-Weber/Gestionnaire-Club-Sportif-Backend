package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.AthleteController;
import com.mns.cda.filsrouge.mockService.MockAthleteService;
import com.mns.cda.filsrouge.dto.AthleteDTO;
import com.mns.cda.filsrouge.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public class AthleteControllerUnitTest {

    // GET ALL
    @Test
    public void getAthleteList_MustReturnList() {
        AthleteController controller = new AthleteController(new MockAthleteService());

        List<Athlete> response = controller.getAthleteList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }

    // GET BY ID
    @Test
    public void getAthleteByIdExist_MustReturnCode200() {
        AthleteController controller = new AthleteController(new MockAthleteService());

        ResponseEntity<Athlete> response = controller.getAthleteById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void getAthleteByIdNotExist_MustReturnCode404() {
        AthleteController controller = new AthleteController(new MockAthleteService());

        ResponseEntity<Athlete> response = controller.getAthleteById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // GET BY EVENT
    @Test
    public void findAthleteByEvent_MustReturnList() {
        AthleteController controller = new AthleteController(new MockAthleteService());

        List<AthleteDTO> response = controller.findAthleteByEvent(1);

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
    }

    // GET BY TEAM
    @Test
    public void findAthleteByTeam_MustReturnList() {
        AthleteController controller = new AthleteController(new MockAthleteService());

        List<AthleteDTO> response = controller.findAthleteByTeam(1);

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
    }

    // CREATE
    @Test
    public void createAthlete_MustReturnCode201() {
        AthleteController controller = new AthleteController(new MockAthleteService());
        Athlete athlete = new Athlete(1,
                "Dupont","Jean",
                LocalDate.now().minusDays(1),
                List.of(new Event()),
                List.of(new Team()),
                List.of(new Discipline()),
                new Country(),
                List.of(new Vote()));

        ResponseEntity<Athlete> response = controller.create(athlete);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdAthlete());
    }

    // DELETE
    @Test
    public void deleteAthleteExist_MustReturnCode204() {
        AthleteController controller = new AthleteController(new MockAthleteService());

        ResponseEntity<Athlete> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteAthleteNotExist_MustReturnCode404() {
        AthleteController controller = new AthleteController(new MockAthleteService());

        ResponseEntity<Athlete> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateAthleteExist_MustReturnCode200() {
        AthleteController controller = new AthleteController(new MockAthleteService());
        Athlete athlete = new Athlete(1,
                "Dupont","Jean",
                LocalDate.now().minusDays(1),
                List.of(new Event()),
                List.of(new Team()),
                List.of(new Discipline()),
                new Country(),
                List.of(new Vote()));

        ResponseEntity<Athlete> response = controller.update(1, athlete);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdAthlete());
    }

    @Test
    public void updateAthleteNotExist_MustReturnCode404() {
        AthleteController controller = new AthleteController(new MockAthleteService());
        Athlete athlete = new Athlete(1,
                "Dupont","Jean",
                LocalDate.now().minusDays(1),
                List.of(new Event()),
                List.of(new Team()),
                List.of(new Discipline()),
                new Country(),
                List.of(new Vote()));

        ResponseEntity<Athlete> response = controller.update(999, athlete);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
