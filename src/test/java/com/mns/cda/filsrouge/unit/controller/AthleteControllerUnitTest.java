package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.AthleteController;
import com.mns.cda.filsrouge.mock.MockAthleteDao;
import com.mns.cda.filsrouge.model.Athlete;
import com.mns.cda.filsrouge.model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public class AthleteControllerUnitTest {

    //Test de GetAll
    @Test
    public void getAthleteListAll_MustReturnListOfAll() {
        AthleteController athleteController = new AthleteController(new MockAthleteDao());

        List<Athlete> response = athleteController.getAthleteList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getAthleteByIdExist_MustReturnCode200() {

        AthleteController athleteController = new AthleteController(new MockAthleteDao());
        ResponseEntity<Athlete> response = athleteController.getAthleteById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getAthleteByIdNotExist_MustReturnCode404() {

        AthleteController athleteController = new AthleteController(new MockAthleteDao());
        ResponseEntity<Athlete> response = athleteController.getAthleteById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createAthlete_MustReturnCode201() {
        AthleteController athleteController = new AthleteController(new MockAthleteDao());
        Athlete athlete = new Athlete(10,
                "Test",
                "Test",
                LocalDate.now().minusDays(1),
                List.of(new Event()));

        ResponseEntity<Athlete> response = athleteController.create(athlete);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdAthlete());
    }

    // Test de Delete
    @Test
    public void deleteAthleteExist_MustReturnCode204() {
        AthleteController athleteController = new AthleteController(new MockAthleteDao());

        ResponseEntity<Athlete> response = athleteController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteAthleteNotExist_MustReturnCode404() {
        AthleteController athleteController = new AthleteController(new MockAthleteDao());

        ResponseEntity<Athlete> response = athleteController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateAthlete_MustReturnCode200() {
        AthleteController athleteController = new AthleteController(new MockAthleteDao());
        Athlete athlete = new Athlete(10,
                "Test",
                "Test",
                LocalDate.now().minusDays(1),
                List.of(new Event()));

        ResponseEntity<Athlete> response = athleteController.update(1, athlete);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdAthlete());
    }

    @Test
    public void updateAthleteNotExist_MustReturnCode404() {
        AthleteController athleteController = new AthleteController(new MockAthleteDao());
        Athlete athlete =new Athlete(10,
                "Test","Test",
                LocalDate.now().minusDays(1),
                List.of(new Event()));

        ResponseEntity<Athlete> reponse = athleteController.update(2, athlete);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
