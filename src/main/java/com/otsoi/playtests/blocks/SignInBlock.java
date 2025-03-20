package com.otsoi.playtests.blocks;

import org.springframework.stereotype.Component;

import com.otsoi.playtests.pages.PlaywrightPageElement;

@Component
public class SignInBlock implements PlaywrightPageElement {
    // Selectors
    private final String signInBlock = "#loginPanel";
    private final String usernameInput = "//*[@name ='username']";
    private final String passwordInput = "//*[@name ='password']";
    private final String signInButton = "//*[@value ='Log In']";
    private final String errorMessage = ".error";
    private final String registerLink = "//a[text()='Register']";
    private final String forgotPasswordLink = "//a[text()='Forgot login info?']";

    public void setUsername(String username) {
        getPage().fill(usernameInput, username);
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

    public boolean isVisible() {
        return getPage().isVisible(signInBlock);
    }

    public void clickRegister() {
        getPage().click(registerLink);
    }

    public void clickForgotPassword() {
        getPage().click(forgotPasswordLink);
    }
}