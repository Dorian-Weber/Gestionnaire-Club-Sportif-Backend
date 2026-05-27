package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Event;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class EventUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // eventName : @NotBlank

    @Test
    public void eventNameBlank_MustBeNotValidated() {

        Event event = new Event();
        event.setEventName("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void eventNameNull_MustBeNotValidated() {

        Event event = new Event();
        event.setEventName(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void eventNameOnlySpaces_MustBeNotValidated() {

        Event event = new Event();
        event.setEventName("   ");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventName",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    // eventDescription : @NotBlank

    @Test
    public void eventDescriptionBlank_MustBeNotValidated() {

        Event event = new Event();
        event.setEventDescription("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventDescription",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void eventDescriptionNull_MustBeNotValidated() {

        Event event = new Event();
        event.setEventDescription(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventDescription",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void eventDescriptionOnlySpaces_MustBeNotValidated() {

        Event event = new Event();
        event.setEventDescription("   ");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventDescription",
                "NotBlank"
        );

        Assertions.assertTrue(exists);
    }

    // eventDate : @NotNull, @FutureOrPresent

    @Test
    public void eventDateNull_MustBeNotValidated() {

        Event event = new Event();
        event.setEventDate(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventDate",
                "NotNull"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void eventDateInPast_MustBeNotValidated() {

        Event event = new Event();
        event.setEventDate(LocalDateTime.now().minusDays(1));

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventDate",
                "FutureOrPresent"
        );

        Assertions.assertTrue(exists);
    }

    @Test
    public void eventDateNow_MustBeValidated() {

        Event event = new Event();
        event.setEventDate(LocalDateTime.now().plusSeconds(1));

        boolean existsFuture = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventDate",
                "FutureOrPresent"
        );

        boolean existsNotNull = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventDate",
                "NotNull"
        );

        Assertions.assertFalse(existsFuture);
        Assertions.assertFalse(existsNotNull);
    }

    @Test
    public void eventDateInFuture_MustBeValidated() {

        Event event = new Event();
        event.setEventDate(LocalDateTime.now().plusDays(5));

        boolean existsFuture = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventDate",
                "FutureOrPresent"
        );

        boolean existsNotNull = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventDate",
                "NotNull"
        );

        Assertions.assertFalse(existsFuture);
        Assertions.assertFalse(existsNotNull);
    }
}
