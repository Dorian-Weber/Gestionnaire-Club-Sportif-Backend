package com.mns.cda.filsrouge.unit.controller;

import com.mns.cda.filsrouge.controller.CountryController;
import com.mns.cda.filsrouge.mockDAO.MockCountryDao;
import com.mns.cda.filsrouge.model.Athlete;
import com.mns.cda.filsrouge.model.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CountryControllerUnitTest {

    //Test de GetAll
    @Test
    public void getCountryAll_DoitRetournerUneList() {
        CountryController countryController = new CountryController(new MockCountryDao());

        List<Country> response = countryController.getCountryList();

        Assertions.assertNotNull(response);
        Assertions.assertFalse(response.isEmpty());
        Assertions.assertEquals(1, response.size());
    }


    // Test de GetByID
    @Test
    public void getCountryByIdExist_DoitRetournerCode200() {

        CountryController countryController = new CountryController(new MockCountryDao());
        ResponseEntity<Country> response = countryController.getCountryById(1);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getCountryByIdNotExist_DoitRetournerCode404() {

        CountryController countryController = new CountryController(new MockCountryDao());
        ResponseEntity<Country> response = countryController.getCountryById(2);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Create test qu'il y a bien creation et que l'id est bien mise a null
    @Test
    public void createCountry_DoitRetournerCode201() {
        CountryController countryController = new CountryController(new MockCountryDao());
        Country country = new Country(1,
                "France",
                List.of(new Athlete()));

        ResponseEntity<Country> response = countryController.create(country);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertNull(response.getBody().getIdCountry());
    }

    // Test de Delete
    @Test
    public void deleteCountryExist_DoitRetournerCode204() {
        CountryController countryController = new CountryController(new MockCountryDao());

        ResponseEntity<Country> response = countryController.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }
    @Test
    public void deleteCountryNotExist_DoitRetournerCode404() {
        CountryController countryController = new CountryController(new MockCountryDao());

        ResponseEntity<Country> response = countryController.delete(2);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    // Test de Update

    @Test
    public void updateCountry_DoitRetournerCode200() {
        CountryController countryController = new CountryController(new MockCountryDao());
        Country country = new Country(1,
                "France",
                List.of(new Athlete()));

        ResponseEntity<Country> response = countryController.update(1, country);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1, response.getBody().getIdCountry());
    }

    @Test
    public void updateCountryNotExist_DoitRetournerCode404() {
        CountryController countryController = new CountryController(new MockCountryDao());
        Country country = new Country(1,
                "France",
                List.of(new Athlete()));

        ResponseEntity<Country> reponse = countryController.update(2, country);

        Assertions.assertEquals(HttpStatus.NOT_FOUND, reponse.getStatusCode());

    }
}
