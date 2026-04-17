package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.AppUserController;
import com.mns.cda.filsrouge.mockDAO.MockAppUserDao;
import com.mns.cda.filsrouge.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class AppUserControllerUnitTest {

    //Test de GetAll
    @Test
    public void getAppUserAll_MustReturnList() {
        AppUserController appUserController = new AppUserController(new MockAppUserDao());

        List<AppUser> response = appUserController.getAppUserList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getAppUserByIdExist_MustReturnCode200() {

        AppUserController appUserController = new AppUserController(new MockAppUserDao());
        ResponseEntity<AppUser> response = appUserController.getAppUserById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getAppUserByIdNotExist_MustReturnCode404() {

        AppUserController appUserController = new AppUserController(new MockAppUserDao());
        ResponseEntity<AppUser> response = appUserController.getAppUserById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createAppUser_MustReturnCode201() {
        AppUserController appUserController = new AppUserController(new MockAppUserDao());
        AppUser appUser = new AppUser(1,
                "Test",
                "Test",
                "TestTest",
                "Test@test.com",
                "TestTest1!",
                "0698144242",
                LocalDateTime.now(),
                LocalDateTime.now(),
                new AccountType(),
                List.of(new Relation()),
                List.of(new Relation()),
                List.of(new Vote()),
                List.of(new Reservation()));;

        ResponseEntity<AppUser> response = appUserController.create(appUser);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdAppUser());
    }

    // Test de Delete
    @Test
    public void deleteAppUserExist_MustReturnCode204() {
        AppUserController appUserController = new AppUserController(new MockAppUserDao());

        ResponseEntity<AppUser> response = appUserController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteAppUserNotExist_MustReturnCode404() {
        AppUserController appUserController = new AppUserController(new MockAppUserDao());

        ResponseEntity<AppUser> response = appUserController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateAppUser_MustReturnCode200() {
        AppUserController appUserController = new AppUserController(new MockAppUserDao());
        AppUser appUser = new AppUser(1,
                "Test",
                "Test",
                "TestTest",
                "Test@test.com",
                "TestTest1!",
                "0698144242",
                LocalDateTime.now(),
                LocalDateTime.now(),
                new AccountType(),
                List.of(new Relation()),
                List.of(new Relation()),
                List.of(new Vote()),
                List.of(new Reservation()));

        ResponseEntity<AppUser> response = appUserController.update(1, appUser);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdAppUser());
    }

    @Test
    public void updateAppUserNotExist_MustReturnCode404() {
        AppUserController appUserController = new AppUserController(new MockAppUserDao());
        AppUser appUser = new AppUser(1,
                "Test",
                "Test",
                "TestTest",
                "Test@test.com",
                "TestTest1!",
                "0698144242",
                LocalDateTime.now(),
                LocalDateTime.now(),
                new AccountType(),
                List.of(new Relation()),
                List.of(new Relation()),
                List.of(new Vote()),
                List.of(new Reservation()));

        ResponseEntity<AppUser> reponse = appUserController.update(2, appUser);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
