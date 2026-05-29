package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.PlatformController;
import com.mns.cda.filsrouge.mockService.MockPlatformService;
import com.mns.cda.filsrouge.model.Platform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class PlatformControllerUnitTest {

    // GET ALL
    @Test
    public void getPlatformList_MustReturnList() {
        PlatformController controller = new PlatformController(new MockPlatformService());

        List<Platform> response = controller.getPlatformList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }

    // GET BY ID
    @Test
    public void getPlatformByIdExist_MustReturnCode200() {
        PlatformController controller = new PlatformController(new MockPlatformService());

        ResponseEntity<Platform> response = controller.getPlatformById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void getPlatformByIdNotExist_MustReturnCode404() {
        PlatformController controller = new PlatformController(new MockPlatformService());

        ResponseEntity<Platform> response = controller.getPlatformById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // CREATE
    @Test
    public void createPlatform_MustReturnCode201() {
        PlatformController controller = new PlatformController(new MockPlatformService());
        Platform platform = new Platform(10, "TestTribune", null);

        ResponseEntity<Platform> response = controller.create(platform);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdPlatform());
    }

    // DELETE
    @Test
    public void deletePlatformExist_MustReturnCode204() {
        PlatformController controller = new PlatformController(new MockPlatformService());

        ResponseEntity<Platform> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deletePlatformNotExist_MustReturnCode404() {
        PlatformController controller = new PlatformController(new MockPlatformService());

        ResponseEntity<Platform> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updatePlatformExist_MustReturnCode200() {
        PlatformController controller = new PlatformController(new MockPlatformService());
        Platform platform = new Platform(1, "UpdatedTribune", null);

        ResponseEntity<Platform> response = controller.update(1, platform);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdPlatform());
    }

    @Test
    public void updatePlatformNotExist_MustReturnCode404() {
        PlatformController controller = new PlatformController(new MockPlatformService());
        Platform platform = new Platform(1, "UpdatedTribune", null);

        ResponseEntity<Platform> response = controller.update(999, platform);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
