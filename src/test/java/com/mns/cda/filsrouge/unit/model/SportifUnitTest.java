package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Sportif;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SportifUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom du sportif ne peut pas être vide
    @Test
    public void valideSportifAvecNomSportifBlank_DoitEtreNonValide(){

        Sportif sportif = new Sportif();
        sportif.setNomSportif("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(sportif),
                "nomSportif",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le prénom du sportif ne peut pas être vide
    @Test
    public void valideSportifAvecPrenomSportifBlank_DoitEtreNonValide(){

        Sportif  sportif = new Sportif();
        sportif.setPrenomSportif("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(sportif),
                "prenomSportif",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le nom du sportif ne peut pas être vide
    @Test
    public void valideSportifAvecDateNaissanceSportifBlank_DoitEtreNonValide(){

        Sportif  sportif = new Sportif();
        sportif.setDateNaissanceSportif(null);

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(sportif),
                "dateNaissanceSportif",
                "NotNull");
        Assertions.assertTrue(constraintExist);
    }
}
