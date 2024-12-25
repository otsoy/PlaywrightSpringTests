package com.otsoi.playtests.pages;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component @RequiredArgsConstructor
public class RegisterPage implements WebPage {

    // Selectors
    private final String firstNameInput = "#customer\\.firstName";
    private final String lastNameInput = "#customer\\.lastName";
    private final String addressInput = "#customer\\.address\\.street";
    private final String cityInput = "#customer\\.address\\.city";
    private final String stateInput = "#customer\\.address\\.state";
    private final String zipCodeInput = "#customer\\.address\\.zipCode";
    private final String phoneInput = "#customer\\.phoneNumber";
    private final String ssnInput = "#customer\\.ssn";
    private final String usernameInput = "#customer\\.username";
    private final String usernameError = "#customer\\.username\\.errors";
    private final String passwordInput = "#customer\\.password";
    private final String confirmPasswordInput = "#repeatedPassword";
    private final String registerButton = "//*[@value='Register']";
    private final String messageText = "//*[@id='rightPanel']//p";
    private final String fieldValidationError = ".error";

    public void enterFirstName(String firstName) {
        if (firstName == null)
            return;
        getPage().fill(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        if (lastName == null)
            return;
        getPage().fill(lastNameInput, lastName);
    }

    public void enterAddress(String address) {
        if (address == null)
            return;
        getPage().fill(addressInput, address);
    }

    public void enterCity(String city) {
        if (city == null)
            return;
        getPage().fill(cityInput, city);
    }

    public void enterState(String state) {
        if (state == null)
            return;
        getPage().fill(stateInput, state);
    }

    public void enterZipCode(String zipCode) {
        if (zipCode == null)
            return;
        getPage().fill(zipCodeInput, zipCode);
    }

    public void enterPhone(String phone) {
        if (phone == null)
            return;
        getPage().fill(phoneInput, phone);
    }

    public void enterSsn(String ssn) {
        if (ssn == null)
            return;
        getPage().fill(ssnInput, ssn);
    }

    public void enterUsername(String username) {
        if (username == null)
            return;

        getPage().fill(usernameInput, username);
    }

    public void enterPassword(String password) {
        if (password == null)
            return;

        getPage().fill(passwordInput, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        if (confirmPassword == null)
            return;
        getPage().fill(confirmPasswordInput, confirmPassword);
    }

    public void clickRegister() {
        getPage().click(registerButton);
    }

    public String getMessageText() {
        return getPage().innerText(messageText);
    }

    public String getUsernameError() {
        return getPage().innerText(usernameError);
    }

    public String getFieldValidationError() {
        return getPage().innerText(fieldValidationError);
    }

    @Override
    public boolean isOpened() {
        return getPage().url().endsWith("register");
    }

}