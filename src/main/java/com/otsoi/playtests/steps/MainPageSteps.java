package com.otsoi.playtests.steps;

import com.otsoi.playtests.pages.RegisterPage;
import org.springframework.stereotype.Component;

import com.otsoi.playtests.pages.CustomerLookupPage;
import com.otsoi.playtests.pages.MainPage;

import lombok.RequiredArgsConstructor;

@Component @RequiredArgsConstructor
public class MainPageSteps {
    private final MainPage mainPage;
    private final CustomerLookupPage customerLookupPage;
    private final RegisterPage registerPage;

    public void open() {
        mainPage.open();
    }

    public RegisterPage startRegistration() {
        mainPage.getSignInBlock().clickRegister();
        mainPage.waitForPageLoad();
        return registerPage;
    }

    public CustomerLookupPage navigateToPasswordRecovery() {
        mainPage.open();
        mainPage.getSignInBlock().clickForgotPassword();
        return customerLookupPage;
    }

}
