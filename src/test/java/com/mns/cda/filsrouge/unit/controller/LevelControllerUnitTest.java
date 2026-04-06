package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.LevelController;
import com.mns.cda.filsrouge.mock.MockLevelDao;
import com.mns.cda.filsrouge.model.Level;
import com.mns.cda.filsrouge.model.Platform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class LevelControllerUnitTest {

    //Test de GetAll
    @Test
    public void getLevelAll_MustReturnList() {
        LevelController levelController = new LevelController(new MockLevelDao());

        List<Level> response = levelController.getLevelList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getLevelByIdExist_MustReturnCode200() {

        LevelController levelController = new LevelController(new MockLevelDao());
        ResponseEntity<Level> response = levelController.getLevelById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getLevelByIdNotExist_MustReturnCode404() {

        LevelController levelController = new LevelController(new MockLevelDao());
        ResponseEntity<Level> response = levelController.getLevelById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createLevel_MustReturnCode201() {
        LevelController levelController = new LevelController(new MockLevelDao());
        Level level = new Level(10,
                "Test",
                new Platform());

        ResponseEntity<Level> response = levelController.create(level);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdLevel());
    }

    // Test de Delete
    @Test
    public void deleteLevelExist_MustReturnCode204() {
        LevelController levelController = new LevelController(new MockLevelDao());

        ResponseEntity<Level> response = levelController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteLevelNotExist_MustReturnCode404() {
        LevelController levelController = new LevelController(new MockLevelDao());

        ResponseEntity<Level> response = levelController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateLevel_MustReturnCode200() {
        LevelController levelController = new LevelController(new MockLevelDao());
        Level level = new Level(10,
                "Test",
                new Platform());

        ResponseEntity<Level> response = levelController.update(1, level);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdLevel());
    }

    @Test
    public void updateLevelNotExist_MustReturnCode404() {
        LevelController levelController = new LevelController(new MockLevelDao());
        Level level = new Level(10,
                "Test",
                new Platform());

        ResponseEntity<Level> reponse = levelController.update(2, level);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
