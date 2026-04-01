package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Country;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CountryUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom de l'équipe ne peut pas être vide
    @Test
    public void validCountryWithCountryNameBlank_MustBeNotValidated(){

        Country country = new Country();
        country.setCountryName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(country),
                "countryName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
