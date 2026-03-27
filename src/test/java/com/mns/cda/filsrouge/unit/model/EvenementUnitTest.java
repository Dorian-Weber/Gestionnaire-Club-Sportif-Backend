package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Evenement;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EvenementUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom de l'évènement ne peut pas être vide
    @Test
    public void valideEvenementAvecNomEvenementBlank_DoitEtreNonValide(){

        Evenement  evenement = new Evenement();
        evenement.setNomEvenement("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(evenement),
                "nomEvenement",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que la description de l'évènement ne peut pas être vide
    @Test
    public void valideEvenementAvecDescriptionEvenementBlank_DoitEtreNonValide(){

        Evenement  evenement = new Evenement();
        evenement.setDescriptionEvenement("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(evenement),
                "descriptionEvenement",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que la description de l'évènement ne peut pas être vide
    @Test
    public void valideEvenementAvecDateEvenementBlank_DoitEtreNonValide(){

        Evenement  evenement = new Evenement();
        evenement.setDescriptionEvenement("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(evenement),
                "dateEvenement",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

}
