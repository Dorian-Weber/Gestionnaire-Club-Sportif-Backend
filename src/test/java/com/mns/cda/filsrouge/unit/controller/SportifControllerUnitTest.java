package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.SportifController;
import com.mns.cda.filsrouge.mock.MockSportifDao;
import com.mns.cda.filsrouge.model.Evenement;
import com.mns.cda.filsrouge.model.Sportif;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public class SportifControllerUnitTest {

    //Test de GetAll
    @Test
    public void getSportifAll_DoitRetournerUneList() {
        SportifController sportifController = new SportifController(new MockSportifDao());

        List<Sportif> response = sportifController.getSportifList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getSportifByIdExist_DoitRetournerCode200() {

        SportifController sportifController = new SportifController(new MockSportifDao());
        ResponseEntity<Sportif> response = sportifController.getSportifById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getSportifByIdNotExist_DoitRetournerCode404() {

        SportifController sportifController = new SportifController(new MockSportifDao());
        ResponseEntity<Sportif> response = sportifController.getSportifById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createSportif_DoitRetournerCode201() {
        SportifController sportifController = new SportifController(new MockSportifDao());
        Sportif sportif = new Sportif(10,
                "Test","Test",
                new java.util.Date());

        ResponseEntity<Sportif> response = sportifController.create(sportif);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdSportif());
    }

    // Test de Delete
    @Test
    public void deleteSportifExist_DoitRetournerCode204() {
        SportifController sportifController = new SportifController(new MockSportifDao());

        ResponseEntity<Sportif> response = sportifController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteSportifNotExist_DoitRetournerCode404() {
        SportifController sportifController = new SportifController(new MockSportifDao());

        ResponseEntity<Sportif> response = sportifController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Uptade

    @Test
    public void updateSportif_DoitRetournerCode200() {
        SportifController sportifController = new SportifController(new MockSportifDao());
        Sportif sportif = new Sportif(10,
                "Test","Test",
                new java.util.Date());

        ResponseEntity<Sportif> response = sportifController.update(1, sportif);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdSportif());
    }

    @Test
    public void updateSportifNotExist_DoitRetournerCode404() {
        SportifController sportifController = new SportifController(new MockSportifDao());
        Sportif sportif =new Sportif(10,
                "Test","Test",
                new java.util.Date());

        ResponseEntity<Sportif> reponse = sportifController.update(2, sportif);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
