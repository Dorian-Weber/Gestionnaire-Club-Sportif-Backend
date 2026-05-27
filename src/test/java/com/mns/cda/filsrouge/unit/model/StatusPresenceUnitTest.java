package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.StatusPresence;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StatusPresenceUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // statusPresenceName : @NotBlank

    @Test
    public void statusPresenceNameBlank_MustBeNotValidated() {

        StatusPresence status = new StatusPresence();
        status.setStatusPresenceName("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(status),
                "statusPresenceName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void statusPresenceNameNull_MustBeNotValidated() {

        StatusPresence status = new StatusPresence();
        status.setStatusPresenceName(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(status),
                "statusPresenceName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void statusPresenceNameOnlySpaces_MustBeNotValidated() {

        StatusPresence status = new StatusPresence();
        status.setStatusPresenceName("   ");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(status),
                "statusPresenceName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void statusPresenceNameValid_MustBeValidated() {

        StatusPresence status = new StatusPresence();
        status.setStatusPresenceName("En attente");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(status),
                "statusPresenceName",
                "NotBlank"
        );

        Assertions.assertFalse(exists);
    }
}
