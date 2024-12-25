package com.otsoi.playtests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import com.otsoi.playtests.entities.TestUser;
import com.otsoi.playtests.extensions.AfterEachExtension;
import com.otsoi.playtests.steps.MainPageSteps;
import com.otsoi.playtests.steps.SignInPageSteps;
import com.otsoi.playtests.testData.TestUserFactory;

@SpringBootTest @ExtendWith(AfterEachExtension.class)
public class SignInTests {
    @Autowired
    private MainPageSteps mainPageSteps;

    @Autowired
    private SignInPageSteps signInPageSteps;

    @Test @Description("Successfully sign in")
    public void testSignIn() {
        TestUser user = TestUserFactory.getTestUser();

        mainPageSteps.open();
        var resultPage = signInPageSteps.signIn(user);

        assertFalse(resultPage.getSignInBlock().isVisible(), "Sign in block should disappear after successful login");
    }

    @Test @Description("Sign in with wrong password")
    public void testSignInWrongPassword() {
        TestUser user = TestUser.builder().username("john").password("wrongPassword").build();

        mainPageSteps.open();
        var resultPage = signInPageSteps.signIn(user);

        resultPage.waitUntil(() -> resultPage.getSignInBlock().isVisible());
        assertEquals("The username and password could not be verified.", signInPageSteps.getErrorMessage());
    }

    @Test @Description("Sign in with non-existing user")
    public void testSignInNonExistingUser() {
        TestUser user = TestUser.builder().username("nonExistingUser").password("demo").build();

        mainPageSteps.open();
        var resultPage = signInPageSteps.signIn(user);

        resultPage.waitUntil(() -> resultPage.getSignInBlock().isVisible());
        assertEquals("The username and password could not be verified.", signInPageSteps.getErrorMessage());
    }
}