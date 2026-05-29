package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.CountryController;
import com.mns.cda.filsrouge.mockService.MockCountryService;
import com.mns.cda.filsrouge.model.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CountryControllerUnitTest {

    // GET ALL
    @Test
    public void getCountryList_MustReturnList() {
        CountryController controller = new CountryController(new MockCountryService());

        List<Country> response = controller.getCountryList();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }

    // GET BY ID
    @Test
    public void getCountryByIdExist_MustReturnCode200() {
        CountryController controller = new CountryController(new MockCountryService());

        ResponseEntity<Country> response = controller.getCountryById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
    }

    @Test
    public void getCountryByIdNotExist_MustReturnCode404() {
        CountryController controller = new CountryController(new MockCountryService());

        ResponseEntity<Country> response = controller.getCountryById(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // CREATE
    @Test
    public void createCountry_MustReturnCode201() {
        CountryController controller = new CountryController(new MockCountryService());
        Country country = new Country(10, "TestLand", null);

        ResponseEntity<Country> response = controller.create(country);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNull(response.getBody().getIdCountry());
    }

    // DELETE
    @Test
    public void deleteCountryExist_MustReturnCode204() {
        CountryController controller = new CountryController(new MockCountryService());

        ResponseEntity<Country> response = controller.delete(1);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void deleteCountryNotExist_MustReturnCode404() {
        CountryController controller = new CountryController(new MockCountryService());

        ResponseEntity<Country> response = controller.delete(999);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // UPDATE
    @Test
    public void updateCountryExist_MustReturnCode200() {
        CountryController controller = new CountryController(new MockCountryService());
        Country country = new Country(1, "UpdatedLand", null);

        ResponseEntity<Country> response = controller.update(1, country);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, response.getBody().getIdCountry());
    }

    @Test
    public void updateCountryNotExist_MustReturnCode404() {
        CountryController controller = new CountryController(new MockCountryService());
        Country country = new Country(1, "UpdatedLand", null);

        ResponseEntity<Country> response = controller.update(999, country);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
