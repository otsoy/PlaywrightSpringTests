package com.otsoi.playtests.pages;

import org.springframework.stereotype.Component;

import com.otsoi.playtests.entities.TestUser;

@Component
public class CustomerLookupPage implements WebPage {

    // Form fields
    private final String firstNameInput = "#firstName";
    private final String lastNameInput = "#lastName";
    private final String streetInput = "#address\\.street";
    private final String cityInput = "#address\\.city";
    private final String stateInput = "#address\\.state";
    private final String zipCodeInput = "#address\\.zipCode";
    private final String ssnInput = "#ssn";
    private final String findLoginInfoButton = "input[value='Find My Login Info']";
    private final String successMessage = "#rightPanel p";
    private final String usernameInfo = "#rightPanel p b:text('Username') + :text";
    private final String passwordInfo = "#rightPanel p b:text('Password') + :text";

    public void enterFirstName(String firstName) {
        getPage().fill(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        getPage().fill(lastNameInput, lastName);
    }

    public void enterStreet(String street) {
        getPage().fill(streetInput, street);
    }

    public void enterCity(String city) {
        getPage().fill(cityInput, city);
    }

    public void enterState(String state) {
        getPage().fill(stateInput, state);
    }

    public void enterZipCode(String zipCode) {
        getPage().fill(zipCodeInput, zipCode);
    }

    public void enterSSN(String ssn) {
        getPage().fill(ssnInput, ssn);
    }

    public void clickFindLoginInfo() {
        getPage().click(findLoginInfoButton);
    }

    @Override
    public boolean isOpened() {
        return getPage().isVisible(firstNameInput);
    }

    public void recoverPassword(TestUser user) {
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterStreet(user.getAddress());
        enterCity(user.getCity());
        enterState(user.getState());
        enterZipCode(user.getZipCode());
        enterSSN(user.getSsn());
        clickFindLoginInfo();
    }

    public String getSuccessMessage() {
        return getPage().textContent(successMessage);
    }

    public String getUsername() {
        return getPage().textContent(usernameInfo).trim();
    }

    public String getPassword() {
        return getPage().textContent(passwordInfo).trim();
    }
}