package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.AppUserController;
import com.mns.cda.filsrouge.enumerate.UserVisibility;
import com.mns.cda.filsrouge.mockService.MockAppUserService;
import com.mns.cda.filsrouge.mockAggregation.MockUserPublicAggregation;
import com.mns.cda.filsrouge.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class AppUserControllerUnitTest {

    // GET ALL
    @Test
    public void getAppUserList_MustReturnList() {
        AppUserController controller = new AppUserController(new MockUserPublicAggregation(), new MockAppUserService());

        List<AppUser> response = controller.getAppUserList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }

    // GET BY ID
    @Test
    public void getAppUserByIdExist_MustReturnCode200() {
        AppUserController controller = new AppUserController(new MockUserPublicAggregation(), new MockAppUserService());

        ResponseEntity<AppUser> response = controller.getAppUserById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void getAppUserByIdNotExist_MustReturnCode404() {
        AppUserController controller = new AppUserController(new MockUserPublicAggregation(), new MockAppUserService());

        ResponseEntity<AppUser> response = controller.getAppUserById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // DELETE
    @Test
    public void deleteAppUserExist_MustReturnCode204() {
        AppUserController controller = new AppUserController(new MockUserPublicAggregation(), new MockAppUserService());

        ResponseEntity<AppUser> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteAppUserNotExist_MustReturnCode404() {
        AppUserController controller = new AppUserController(new MockUserPublicAggregation(), new MockAppUserService());

        ResponseEntity<AppUser> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateAppUserExist_MustReturnCode200() {
        AppUserController controller = new AppUserController(new MockUserPublicAggregation(), new MockAppUserService());
        AppUser appUser = new AppUser(1,
                "Test",
                "Test",
                "TestTest",
                "Test@test.com",
                "TestTest1!",
                "0698144242",
                UserVisibility.PRIVATE,
                LocalDateTime.now(),
                LocalDateTime.now(),
                new AccountType(),
                List.of(new Relation()),
                List.of(new Relation()),
                List.of(new Vote()),
                List.of(new Reservation()));

        ResponseEntity<AppUser> response = controller.update(1, appUser);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdAppUser());
    }

    @Test
    public void updateAppUserNotExist_MustReturnCode404() {
        AppUserController controller = new AppUserController(new MockUserPublicAggregation(), new MockAppUserService());
        AppUser appUser = new AppUser(1,
                "Test",
                "Test",
                "TestTest",
                "Test@test.com",
                "TestTest1!",
                "0698144242",
                UserVisibility.PRIVATE,
                LocalDateTime.now(),
                LocalDateTime.now(),
                new AccountType(),
                List.of(new Relation()),
                List.of(new Relation()),
                List.of(new Vote()),
                List.of(new Reservation()));

        ResponseEntity<AppUser> response = controller.update(999, appUser);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
