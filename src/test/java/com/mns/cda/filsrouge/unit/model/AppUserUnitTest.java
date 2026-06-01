package com.mns.cda.filsrouge.unit.model;

import com.mns.cda.filsrouge.model.AppUser;
import com.mns.cda.filsrouge.TestUtilitaire;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppUserUnitTest {

    public static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    // appUserName : @NotBlank, @Size(min=1,max=50)

    @Test
    public void appUserNameBlank_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserName("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserName",
                "NotBlank");

        Assertions.assertTrue(exists);
    }

    @Test
    public void appUserNameNull_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserName(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserName",
                "NotBlank");

        Assertions.assertTrue(exists);
    }

    @Test
    public void appUserNameTooLong_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserName("A".repeat(51));

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserName",
                "Size");

        Assertions.assertTrue(exists);
    }

    @Test
    public void appUserNameValid_MustBeValidated() {
        AppUser user = new AppUser();
        user.setAppUserName("Martin");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserName",
                "NotBlank");

        Assertions.assertFalse(exists);
    }

    // appUserFirstName : @NotBlank, @Size(min=1,max=50)

    @Test
    public void appUserFirstNameBlank_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserFirstName("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserFirstName",
                "NotBlank");

        Assertions.assertTrue(exists);
    }

    @Test
    public void appUserFirstNameTooLong_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserFirstName("A".repeat(51));

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserFirstName",
                "Size");

        Assertions.assertTrue(exists);
    }

    // appUserPseudo : @NotBlank, @Size(min=5,max=30), @Pattern

    @Test
    public void appUserPseudoBlank_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserPseudo("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserPseudo",
                "NotBlank");

        Assertions.assertTrue(exists);
    }

    @Test
    public void appUserPseudoTooShort_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserPseudo("abc");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserPseudo",
                "Size");

        Assertions.assertTrue(exists);
    }

    @Test
    public void appUserPseudoInvalidPattern_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserPseudo("invalid pseudo!");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserPseudo",
                "Pattern");

        Assertions.assertTrue(exists);
    }

    // appUserEmail : @NotBlank, @Email, @Size(max=100)

    @Test
    public void appUserEmailBlank_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserEmail("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserEmail",
                "NotBlank");

        Assertions.assertTrue(exists);
    }

    @Test
    public void appUserEmailInvalid_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserEmail("invalid-email");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserEmail",
                "Email");

        Assertions.assertTrue(exists);
    }

    @Test
    public void appUserEmailTooLong_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserEmail("a".repeat(101) + "@mail.com");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserEmail",
                "Size");

        Assertions.assertTrue(exists);
    }

    // appUserPassword : @NotBlank, @Pattern (mot de passe fort)

    @Test
    public void appUserPasswordBlank_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserPassword("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserPassword",
                "NotBlank");

        Assertions.assertTrue(exists);
    }

    @Test
    public void appUserPasswordWeak_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserPassword("weakpass");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserPassword",
                "Pattern");

        Assertions.assertTrue(exists);
    }

    // appUserPhone : @NotBlank, @Pattern

    @Test
    public void appUserPhoneBlank_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserPhone("");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserPhone",
                "NotBlank");

        Assertions.assertTrue(exists);
    }

    @Test
    public void appUserPhoneInvalid_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserPhone("12-34-56");

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user, AppUser.OnCreate.class),
                "appUserPhone",
                "Pattern");

        Assertions.assertTrue(exists);
    }

    // appUserVisibility : @NotNull

    @Test
    public void appUserVisibilityNull_MustBeNotValidated() {
        AppUser user = new AppUser();
        user.setAppUserVisibility(null);

        boolean exists = TestUtilitaire.constraintViolationExist(
                validator.validate(user),
                "appUserVisibility",
                "NotNull");

        Assertions.assertTrue(exists);
    }
}
