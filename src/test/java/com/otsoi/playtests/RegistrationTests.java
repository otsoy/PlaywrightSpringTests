package com.otsoi.playtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import com.otsoi.playtests.entities.RegistrationField;
import com.otsoi.playtests.entities.TestUser;
import com.otsoi.playtests.extensions.AfterEachExtension;
import com.otsoi.playtests.steps.MainPageSteps;
import com.otsoi.playtests.steps.RegisterPageSteps;
import com.otsoi.playtests.testData.TestUserFactory;

@SpringBootTest @ExtendWith(AfterEachExtension.class)
public class RegistrationTests {
    @Autowired
    private MainPageSteps mainPageSteps;

    @Autowired
    private RegisterPageSteps registerPageSteps;

    @Test @Description("Successfully registration")
    public void testRegister() {
        mainPageSteps.open();
        mainPageSteps.startRegistration();
        var resultPage = registerPageSteps.registerRandom();

        assertEquals("Your account was created successfully. You are now logged in.", resultPage.getMessageText());
    }

    @Test
    public void testRegisterExisting() {
        TestUser user = TestUserFactory.createRandom();
        mainPageSteps.open();
        mainPageSteps.startRegistration();
        registerPageSteps.register(user);
        registerPageSteps.logout();

        mainPageSteps.open();
        mainPageSteps.startRegistration();

        var resultPage = registerPageSteps.register(user);

        assertEquals("This username already exists.", resultPage.getUsernameError());
    }

    @ParameterizedTest @EnumSource(value = RegistrationField.class, mode = EnumSource.Mode.EXCLUDE, names = { "PHONE" })
    public void testRequiredFields(RegistrationField field) {
        TestUser user = TestUserFactory.createRandom(List.of(field));

        mainPageSteps.open();
        mainPageSteps.startRegistration();
        var resultPage = registerPageSteps.register(user);

        assertEquals(field + " is required.", resultPage.getFieldValidationError(), "Test User" + user);
    }
}
