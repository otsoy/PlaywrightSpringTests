package com.otsoi.playtests.pages;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component @RequiredArgsConstructor
public class SignInPage implements WebPage {

    // Selectors
    private final String signInBlock = "#loginPanel";
    private final String emailInput = "#Email";
    private final String passwordInput = "#Password";
    private final String signInButton = "//*[text()='Log in']";
    private final String errorMessage = ".error-message";

    public void setEmail(String email) {
        getPage().fill(emailInput, email);
    }

    public void setPassword(String password) {
        getPage().fill(passwordInput, password);
    }

    public void clickSignIn() {
        getPage().click(signInButton);
    }

    public String getErrorMessage() {
        return getPage().textContent(errorMessage);
    }

    public boolean isSignInBlockVisible() {
        return getPage().isVisible(signInBlock);
    }

    @Override
    public boolean isOpened() {
        return isSignInBlockVisible();
    }
}