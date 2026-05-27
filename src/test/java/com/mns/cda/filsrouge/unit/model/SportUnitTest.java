package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Sport;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SportUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // sportName : @NotBlank

    @Test
    public void sportNameBlank_MustBeNotValidated() {

        Sport sport = new Sport();
        sport.setSportName("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(sport),
                "sportName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void sportNameNull_MustBeNotValidated() {

        Sport sport = new Sport();
        sport.setSportName(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(sport),
                "sportName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void sportNameOnlySpaces_MustBeNotValidated() {

        Sport sport = new Sport();
        sport.setSportName("   ");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(sport),
                "sportName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void sportNameValid_MustBeValidated() {

        Sport sport = new Sport();
        sport.setSportName("Athlétisme");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(sport),
                "sportName",
                "NotBlank"
        );

        Assertions.assertFalse(exists);
    }
}
