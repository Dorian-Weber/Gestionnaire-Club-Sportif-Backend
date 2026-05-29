package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.AccountTypeController;
import com.mns.cda.filsrouge.mockService.MockAccountTypeService;
import com.mns.cda.filsrouge.model.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AccountTypeControllerUnitTest {

    // GET ALL
    @Test
    public void getAccountTypeAll_MustReturnList() {
        AccountTypeController controller = new AccountTypeController(new MockAccountTypeService());

        List<AccountType> response = controller.getAccountTypeList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(2, response.size());
    }

    // GET BY ID
    @Test
    public void getAccountTypeByIdExist_MustReturnCode200() {
        AccountTypeController controller = new AccountTypeController(new MockAccountTypeService());

        ResponseEntity<AccountType> response = controller.getAccountTypeById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void getAccountTypeByIdNotExist_MustReturnCode404() {
        AccountTypeController controller = new AccountTypeController(new MockAccountTypeService());

        ResponseEntity<AccountType> response = controller.getAccountTypeById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // CREATE
    @Test
    public void createAccountType_MustReturnCode201() {
        AccountTypeController controller = new AccountTypeController(new MockAccountTypeService());
        AccountType accountType = new AccountType(10, "Test");

        ResponseEntity<AccountType> response = controller.create(accountType);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdAccountType());
    }

    // DELETE
    @Test
    public void deleteAccountTypeExist_MustReturnCode204() {
        AccountTypeController controller = new AccountTypeController(new MockAccountTypeService());

        ResponseEntity<AccountType> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteAccountTypeNotExist_MustReturnCode404() {
        AccountTypeController controller = new AccountTypeController(new MockAccountTypeService());

        ResponseEntity<AccountType> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateAccountTypeExist_MustReturnCode200() {
        AccountTypeController controller = new AccountTypeController(new MockAccountTypeService());
        AccountType accountType = new AccountType(1, "Updated");

        ResponseEntity<AccountType> response = controller.update(1, accountType);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdAccountType());
    }

    @Test
    public void updateAccountTypeNotExist_MustReturnCode404() {
        AccountTypeController controller = new AccountTypeController(new MockAccountTypeService());
        AccountType accountType = new AccountType(1, "Updated");

        ResponseEntity<AccountType> response = controller.update(999, accountType);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
