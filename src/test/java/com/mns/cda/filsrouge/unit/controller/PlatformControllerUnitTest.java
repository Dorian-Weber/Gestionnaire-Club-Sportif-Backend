package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.PlatformController;
import com.mns.cda.filsrouge.mock.MockPlatformDao;
import com.mns.cda.filsrouge.model.Platform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class PlatformControllerUnitTest {

    //Test de GetAll
    @Test
    public void getPlatformAll_MustReturnList() {
        PlatformController platformController = new PlatformController(new MockPlatformDao());

        List<Platform> response = platformController.getPlatformList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getPlatformByIdExist_MustReturnCode200() {

        PlatformController platformController = new PlatformController(new MockPlatformDao());
        ResponseEntity<Platform> response = platformController.getPlatformById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getPlatformByIdNotExist_MustReturnCode404() {

        PlatformController platformController = new PlatformController(new MockPlatformDao());
        ResponseEntity<Platform> response = platformController.getPlatformById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createPlatform_MustReturnCode201() {
        PlatformController platformController = new PlatformController(new MockPlatformDao());
        Platform platform = new Platform(10,
                "Test");

        ResponseEntity<Platform> response = platformController.create(platform);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdPlatform());
    }

    // Test de Delete
    @Test
    public void deletePlatformExist_MustReturnCode204() {
        PlatformController platformController = new PlatformController(new MockPlatformDao());

        ResponseEntity<Platform> response = platformController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deletePlatformNotExist_MustReturnCode404() {
        PlatformController platformController = new PlatformController(new MockPlatformDao());

        ResponseEntity<Platform> response = platformController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updatePlatform_MustReturnCode200() {
        PlatformController platformController = new PlatformController(new MockPlatformDao());
        Platform platform = new Platform(10,
                "Test");

        ResponseEntity<Platform> response = platformController.update(1, platform);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdPlatform());
    }

    @Test
    public void updatePlatformNotExist_MustReturnCode404() {
        PlatformController platformController = new PlatformController(new MockPlatformDao());
        Platform platform = new Platform(10, "Test");

        ResponseEntity<Platform> reponse = platformController.update(2, platform);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
