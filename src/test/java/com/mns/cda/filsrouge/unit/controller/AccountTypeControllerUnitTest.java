package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.AccountTypeController;
import com.mns.cda.filsrouge.mockDAO.MockAccountTypeDao;
import com.mns.cda.filsrouge.mockService.MockAccountTypeService;
import com.mns.cda.filsrouge.model.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AccountTypeControllerUnitTest {

    //Test de GetAll
    @Test
    public void getAccountTypeAll_MustReturnList() {
        AccountTypeController accountTypeController = new AccountTypeController(new MockAccountTypeService());

        List<AccountType> response = accountTypeController.getAccountTypeList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(2, response.size());
    }


    // Test de GetByID
    @Test
    public void getAccountTypeByIdExist_MustReturnCode200() {

        AccountTypeController accountTypeController = new AccountTypeController(new MockAccountTypeService());
        ResponseEntity<AccountType> response = accountTypeController.getAccountTypeById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getAccountTypeByIdNotExist_MustReturnCode404() {

        AccountTypeController accountTypeController = new AccountTypeController(new MockAccountTypeService());
        ResponseEntity<AccountType> response = accountTypeController.getAccountTypeById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createAccountType_MustReturnCode201() {
        AccountTypeController accountTypeController = new AccountTypeController(new MockAccountTypeService());
        AccountType accountType = new AccountType(10,
                "Test");

        ResponseEntity<AccountType> response = accountTypeController.create(accountType);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdAccountType());
    }

    // Test de Delete
    @Test
    public void deleteAccountTypeExist_MustReturnCode204() {
        AccountTypeController accountTypeController = new AccountTypeController(new MockAccountTypeService());

        ResponseEntity<AccountType> response = accountTypeController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteAccountTypeNotExist_MustReturnCode404() {
        AccountTypeController accountTypeController = new AccountTypeController(new MockAccountTypeService());

        ResponseEntity<AccountType> response = accountTypeController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update
    @Test
    public void updateAccountType_MustReturnCode200() {
        AccountTypeController accountTypeController = new AccountTypeController(new MockAccountTypeService());
        AccountType accountType = new AccountType(1,
                "Test");

        ResponseEntity<AccountType> response = accountTypeController.update(1, accountType);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdAccountType());
    }

    @Test
    public void updateAccountTypeNotExist_MustReturnCode404() {
        AccountTypeController accountTypeController = new AccountTypeController(new MockAccountTypeService());
        AccountType accountType = new AccountType(1, "Test");

        ResponseEntity<AccountType> reponse = accountTypeController.update(2, accountType);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
