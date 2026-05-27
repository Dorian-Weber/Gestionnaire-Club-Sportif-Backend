package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.EventType;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EventTypeUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // eventTypeName : @NotBlank

    @Test
    public void eventTypeNameBlank_MustBeNotValidated() {

        EventType eventType = new EventType();
        eventType.setEventTypeName("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(eventType),
                "eventTypeName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void eventTypeNameNull_MustBeNotValidated() {

        EventType eventType = new EventType();
        eventType.setEventTypeName(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(eventType),
                "eventTypeName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void eventTypeNameOnlySpaces_MustBeNotValidated() {

        EventType eventType = new EventType();
        eventType.setEventTypeName("   ");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(eventType),
                "eventTypeName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void eventTypeNameValid_MustBeValidated() {

        EventType eventType = new EventType();
        eventType.setEventTypeName("Tournament");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(eventType),
                "eventTypeName",
                "NotBlank"
        );

        Assertions.assertFalse(exists);
    }
}
