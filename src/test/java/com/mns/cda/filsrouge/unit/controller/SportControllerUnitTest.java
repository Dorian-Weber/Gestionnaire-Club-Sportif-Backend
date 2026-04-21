package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.SportController;
import com.mns.cda.filsrouge.mockService.MockSportService;
import com.mns.cda.filsrouge.model.Discipline;
import com.mns.cda.filsrouge.model.Event;
import com.mns.cda.filsrouge.model.Sport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class SportControllerUnitTest {

    //Test de GetAll
    @Test
    public void getSportAll_DoitRetournerUneList() {
        SportController sportController = new SportController(new MockSportService());

        List<Sport> response = sportController.getSportList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getSportByIdExist_DoitRetournerCode200() {

        SportController sportController = new SportController(new MockSportService());
        ResponseEntity<Sport> response = sportController.getSportById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getSportByIdNotExist_DoitRetournerCode404() {

        SportController sportController = new SportController(new MockSportService());
        ResponseEntity<Sport> response = sportController.getSportById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createSport_DoitRetournerCode201() {
        SportController sportController = new SportController(new MockSportService());
        Sport sport = new Sport(10,
                "Test",
                List.of(new Discipline()),
                List.of(new Event()));

        ResponseEntity<Sport> response = sportController.create(sport);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdSport());
    }

    // Test de Delete
    @Test
    public void deleteSportExist_DoitRetournerCode204() {
        SportController sportController = new SportController(new MockSportService());

        ResponseEntity<Sport> response = sportController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteSportNotExist_DoitRetournerCode404() {
        SportController sportController = new SportController(new MockSportService());

        ResponseEntity<Sport> response = sportController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateSport_DoitRetournerCode200() {
        SportController sportController = new SportController(new MockSportService());
        Sport sport = new Sport(10,
                "Test",
                List.of(new Discipline()),
                List.of(new Event()));

        ResponseEntity<Sport> response = sportController.update(1, sport);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdSport());
    }

    @Test
    public void updateSportNotExist_DoitRetournerCode404() {
        SportController sportController = new SportController(new MockSportService());
        Sport sport = new Sport(10,
                "Test",
                List.of(new Discipline()),
                List.of(new Event()));

        ResponseEntity<Sport> reponse = sportController.update(2, sport);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
