package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Event;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EventUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom de l'évènement ne peut pas être vide
    @Test
    public void validEventWithEventNameBlank_MustBeNotValidated(){

        Event event = new Event();
        event.setEventName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que la description de l'évènement ne peut pas être vide
    @Test
    public void validEventWithEventDescriptionBlank_MustBeNotValidated(){

        Event event = new Event();
        event.setEventDescription("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventDescription",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que la date de l'évènement ne peut pas être vide
    @Test
    public void validEventWithEventDateBlank_MustBeNotValidated(){

        Event event = new Event();
        event.setEventDate(null);

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(event),
                "eventDate",
                "NotNull");
        Assertions.assertTrue(constraintExist);
    }

}
