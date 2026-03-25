package com.mns.cda.filsrouge.unit;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.Discipline;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DisciplineUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom de la discipline ne peut pas être vide
    @Test
    public void valideDisciplineAvecNomDisciplineBlank_DoitEtreNonValide(){

        Discipline discipline = new Discipline();
        discipline.setNomDiscipline("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(discipline),
                "nomDiscipline",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }


}
