package com.otsoi.playtests.steps;

import org.springframework.stereotype.Component;

import com.otsoi.playtests.entities.TestUser;
import com.otsoi.playtests.pages.MainPage;

import lombok.RequiredArgsConstructor;

@Component @RequiredArgsConstructor
public class SignInPageSteps {
    private final MainPage mainPage;

    public MainPage signIn(TestUser user) {
        mainPage.getSignInBlock().setUsername(user.getUsername());
        mainPage.getSignInBlock().setPassword(user.getPassword());
        mainPage.getSignInBlock().clickSignIn();
        return mainPage;
    }

    public String getErrorMessage() {
        return mainPage.getSignInBlock().getErrorMessage();
    }
}