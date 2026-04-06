package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Platform;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PlatformUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom du type de compte ne peut pas être vide
    @Test
    public void validPlatformWithPlatformNameBlank_MustBeNotValidated(){

        Platform platform = new Platform();
        platform.setPlatformName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(platform),
                "platformName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
