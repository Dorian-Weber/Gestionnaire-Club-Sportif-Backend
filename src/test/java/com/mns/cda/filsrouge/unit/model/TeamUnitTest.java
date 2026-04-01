package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Team;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TeamUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom de l'équipe ne peut pas être vide
    @Test
    public void validTeamWithTeamNameBlank_MustBeNotValidated(){

        Team team = new Team();
        team.setTeamName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(team),
                "teamName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
