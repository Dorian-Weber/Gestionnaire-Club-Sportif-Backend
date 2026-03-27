package com.mns.cda.filsrouge.unit;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Discipline;
import com.mns.cda.filsrouge.model.Sport;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SportUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom du sport ne peut pas être vide
    @Test
    public void valideSportAvecNomSportBlank_DoitEtreNonValide(){

        Sport sport = new Sport();
        sport.setNomSport("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(sport),
                "nomSport",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
