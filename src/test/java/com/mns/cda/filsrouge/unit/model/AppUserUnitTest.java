package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.TestUtilitaire;
import com.mns.cda.filsrouge.model.AppUser;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppUserUnitTest {

    public static Validator validator ;

    @BeforeAll
    public static void init(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // Test pour valider que le nom de l'utilisateur ne peut pas être vide
    @Test
    public void validAppUserWithAppUserNameBlank_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }
    // Test pour valider que le nom de l'utilisateur ne doit pas dépasser 50 caractères
    @Test
    public void validAppUserWithAppUserNameSize_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserName("leezwtxrbiopwwetsxrdchgvhtgbuihniweztxrybuguygftuvtvtvtyvtyvtyctrcetxerxrexerfutii");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserName",
                "Size");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le prénom de l'utilisateur ne peut pas être vide
    @Test
    public void validAppUserWithAppUserFirstNameBlank_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserFirstName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserFirstName",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }
    // Test pour valider que le nom de l'utilisateur ne doit pas dépasser 50 caractères
    @Test
    public void validAppUserWithAppUserFirstNameSize_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserFirstName("leezwtxrbiopwwetsxrdctgbuihniweztxrybuguygftuvtvtvtyvtyvtyctrcetxerxrexerfutii");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserFirstName",
                "Size");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le pseudo de l'utilisateur ne peut pas être vide
    @Test
    public void validAppUserWithAppUserPseudoBlank_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserPseudo("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPseudo",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }
    // Test pour valider que le pseudo de l'utilisateur ne peut pas être de moins de 5 caractères
    @Test
    public void validAppUserWithAppUserPseudoSizeMin_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserPseudo("abc");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPseudo",
                "Size");
        Assertions.assertTrue(constraintExist);
    }
    // Test pour valider que le pseudo de l'utilisateur ne peut pas être de plus de 30 caractères
    @Test
    public void validAppUserWithAppUserPseudoSizeMax_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserPseudo("abciskldoperticnsjheyudoiqepoud");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPseudo",
                "Size");
        Assertions.assertTrue(constraintExist);
    }
    // Test pour valider que le pseudo de l'utilisateur ne peut pas contenir autre chose que des lettres, chiffres et _.
    @Test
    public void validAppUserWithAppUserPseudoFormat_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserPseudo("abciskldop*$");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPseudo",
                "Pattern");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que l'email de l'utilisateur ne peut pas être vide
    @Test
    public void validAppUserWithAppUserEmailBlank_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserEmail("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserEmail",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que l'email de l'utilisateur ne peut pas être de plus de 100 caractères
    @Test
    public void validAppUserWithAppUserEmailSizeMax_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@x.com");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserEmail",
                "Size");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que l'email de l'utilisateur soit au bon format
    @Test
    public void validAppUserWithAppUserEmailFormat_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserEmail("ifzoi");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserEmail",
                "Email");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le mot de passe de l'utilisateur ne peut pas être vide
    @Test
    public void validAppUserWithAppUserPasswordBlank_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserPassword("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPassword",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le mot de passe de l'utilisateur ne peut pas être de moins de 8 caractères
    @Test
    public void validAppUserWithAppUserPasswordSizeMin_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserPassword("abc");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPassword",
                "Size");
        Assertions.assertTrue(constraintExist);
    }
    // Test pour valider que le mot de passe de l'utilisateur ne peut pas être de plus de 50 caractères
    @Test
    public void validAppUserWithAppUserPasswordSizeMax_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserPassword("abciskldoperticnsjheainuienuinczuinuincuinznuicnicznyudoiqepoud");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPassword",
                "Size");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le mot de passe de l'utilisateur utilise le bon format au moins 1 majuscule, 1 minuscule, un caractère spécial et un chiffre
    @Test
    public void validAppUserWithAppUserPasswordFormat_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserPassword("abciskldo");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPassword",
                "Pattern");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le mot de passe de l'utilisateur utilise le bon format au moins 1 majuscule, 1 minuscule, un caractère spécial et un chiffre
    @Test
    public void validAppUserWithAppUserPasswordFormat_MustBeValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserPassword("abcIskldo9!");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPassword",
                "Pattern");
        Assertions.assertFalse(constraintExist);
    }

    // Test pour valider que le numéro de téléphone de l'utilisateur ne peut pas être vide
    @Test
    public void validAppUserWithAppUserPhoneBlank_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserName("");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPhone",
                "NotBlank");
        Assertions.assertTrue(constraintExist);
    }

    // Test pour valider que le numéro de téléphone de l'utilisateur est du bon format
    @Test
    public void validAppUserWithAppUserPhoneFormatLetter_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserPhone("ndhiz");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPhone",
                "Pattern");
        Assertions.assertTrue(constraintExist);
    }
    // Test pour valider que le numéro de téléphone de l'utilisateur est du bon format
    @Test
    public void validAppUserWithAppUserPhoneFormatNumber_MustBeNotValidated(){

        AppUser appUser = new AppUser();
        appUser.setAppUserPhone("76364536261689699");

        boolean constraintExist = TestUtilitaire.constraintViolationExist(
                validator.validate(appUser),
                "AppUserPhone",
                "Pattern");
        Assertions.assertTrue(constraintExist);
    }


}
