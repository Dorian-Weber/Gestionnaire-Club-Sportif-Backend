package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.EventType;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EventTypeUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom du typeevenement ne peut pas être vide
    @Test
    public void validEventTypeWithEventTypeNameBlank_MustBeNotValidated(){

        EventType eventType = new EventType();
        eventType.setEventTypeName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(eventType),
                "EventTypeName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
