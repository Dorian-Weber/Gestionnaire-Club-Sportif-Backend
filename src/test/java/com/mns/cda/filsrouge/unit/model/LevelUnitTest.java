package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Level;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LevelUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom du type de compte ne peut pas être vide
    @Test
    public void validLevelWithLevelNameBlank_MustBeNotValidated(){

        Level level = new Level();
        level.setLevelName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(level),
                "levelName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
