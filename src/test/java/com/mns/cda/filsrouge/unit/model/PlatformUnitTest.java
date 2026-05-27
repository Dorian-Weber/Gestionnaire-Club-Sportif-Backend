package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Platform;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PlatformUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // platformName : @NotBlank

    @Test
    public void platformNameBlank_MustBeNotValidated() {

        Platform platform = new Platform();
        platform.setPlatformName("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(platform),
                "platformName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void platformNameNull_MustBeNotValidated() {

        Platform platform = new Platform();
        platform.setPlatformName(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(platform),
                "platformName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void platformNameOnlySpaces_MustBeNotValidated() {

        Platform platform = new Platform();
        platform.setPlatformName("   ");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(platform),
                "platformName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void platformNameValid_MustBeValidated() {

        Platform platform = new Platform();
        platform.setPlatformName("Tribune Nord");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(platform),
                "platformName",
                "NotBlank"
        );

        Assertions.assertFalse(exists);
    }
}
