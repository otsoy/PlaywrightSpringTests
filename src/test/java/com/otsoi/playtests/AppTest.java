package com.otsoi.playtests;

import com.otsoi.playtests.entities.RegistrationField;
import com.otsoi.playtests.entities.TestUser;
import com.otsoi.playtests.pages.RegisterPage;
import com.otsoi.playtests.pages.RegisterResultPage;
import com.otsoi.playtests.steps.MainPageSteps;
import com.otsoi.playtests.steps.RegisterPageSteps;
import com.otsoi.playtests.testData.TestUserFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AppTest
{
    @Autowired
    private MainPageSteps mainPageSteps;

    @Autowired
    private RegisterPageSteps registerPageSteps;


    @Test
    @Description("Successfully registration")
    public void testRegister()
    {
        mainPageSteps.open();
        mainPageSteps.startRegistration();
        var resultPage = registerPageSteps.registerRandom().to(RegisterResultPage.class);

        assertTrue(resultPage.isOpened());
    }

    @Test
    public void testRegisterExisting()
    {
        TestUser user = TestUserFactory.createRandom();
        mainPageSteps.open();
        mainPageSteps.startRegistration();
        registerPageSteps.register(user);
        registerPageSteps.logout();

        mainPageSteps.open();
        mainPageSteps.startRegistration();

        var resultPage = registerPageSteps.register(user);

       assertInstanceOf(RegisterPage.class, resultPage);
       assertEquals("The specified email already exists", resultPage.to(RegisterPage.class).getSummaryError() )    ;
    }

    @ParameterizedTest
    @EnumSource(value = RegistrationField.class, names = {"GENDER"}, mode = EnumSource.Mode.EXCLUDE)
    public void testRequiredFields(RegistrationField field)
    {
        TestUser user = TestUserFactory.createRandom(List.of(field));

        mainPageSteps.open();
        mainPageSteps.startRegistration();
        var resultPage =  registerPageSteps.register(user).to(RegisterPage.class);

        assertEquals(field + " is required.", resultPage.to(RegisterPage.class).getFieldValidationError() )    ;
    }
}
