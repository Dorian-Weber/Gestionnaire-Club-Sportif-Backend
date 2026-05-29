package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.LevelController;
import com.mns.cda.filsrouge.mockService.MockLevelService;
import com.mns.cda.filsrouge.model.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class LevelControllerUnitTest {

    // GET ALL
    @Test
    public void getLevelList_MustReturnList() {
        LevelController controller = new LevelController(new MockLevelService());

        List<Level> response = controller.getLevelList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }

    // GET BY ID
    @Test
    public void getLevelByIdExist_MustReturnCode200() {
        LevelController controller = new LevelController(new MockLevelService());

        ResponseEntity<Level> response = controller.getLevelById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void getLevelByIdNotExist_MustReturnCode404() {
        LevelController controller = new LevelController(new MockLevelService());

        ResponseEntity<Level> response = controller.getLevelById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // CREATE
    @Test
    public void createLevel_MustReturnCode201() {
        LevelController controller = new LevelController(new MockLevelService());
        Level level = new Level(10, "TestLevel", null, null);

        ResponseEntity<Level> response = controller.create(level);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdLevel());
    }

    // DELETE
    @Test
    public void deleteLevelExist_MustReturnCode204() {
        LevelController controller = new LevelController(new MockLevelService());

        ResponseEntity<Level> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteLevelNotExist_MustReturnCode404() {
        LevelController controller = new LevelController(new MockLevelService());

        ResponseEntity<Level> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateLevelExist_MustReturnCode200() {
        LevelController controller = new LevelController(new MockLevelService());
        Level level = new Level(1, "UpdatedLevel", null, null);

        ResponseEntity<Level> response = controller.update(1, level);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdLevel());
    }

    @Test
    public void updateLevelNotExist_MustReturnCode404() {
        LevelController controller = new LevelController(new MockLevelService());
        Level level = new Level(1, "UpdatedLevel", null, null);

        ResponseEntity<Level> response = controller.update(999, level);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
