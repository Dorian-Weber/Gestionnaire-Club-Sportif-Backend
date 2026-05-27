package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Country;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CountryUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // countryName : @NotBlank

    @Test
    public void validCountryWithCountryNameBlank_MustBeNotValidated() {

        Country country = new Country();
        country.setCountryName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(country),
                "countryName",
                "NotBlank"
        );

        Assertions.assertTrue(constraintExist);
    }

    @Test
    public void validCountryWithCountryNameNull_MustBeNotValidated() {

        Country country = new Country();
        country.setCountryName(null);

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(country),
                "countryName",
                "NotBlank"
        );

        Assertions.assertTrue(constraintExist);
    }

    @Test
    public void validCountryWithCountryNameOnlySpaces_MustBeNotValidated() {

        Country country = new Country();
        country.setCountryName("   ");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(country),
                "countryName",
                "NotBlank"
        );

        Assertions.assertTrue(constraintExist);
    }

    @Test
    public void validCountryWithValidCountryName_MustBeValidated() {

        Country country = new Country();
        country.setCountryName("France");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(country),
                "countryName",
                "NotBlank"
        );

        Assertions.assertFalse(constraintExist);
    }
}
