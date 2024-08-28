package com.otsoi.playtests.pages;

import com.otsoi.playtests.entities.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterPage extends PlaywrightPageElement implements WebPage {

    // Selectors
    private final String genderMaleRadio = "#gender-male";
    private final String genderFemaleRadio = "#gender-female";
    private final String firstNameInput = "#FirstName";
    private final String lastNameInput = "#LastName";
    private final String emailInput = "#Email";
    private final String passwordInput = "#Password";
    private final String confirmPasswordInput = "#ConfirmPassword";
    private final String registerButton = "#register-button";
    private final String summaryError = "//*[contains(@class, 'validation-summary-errors')]//li";
    private final String fieldValidationError = "//*[contains(@class, 'field-validation-error')]";


    public void selectGender(Gender gender) {
        if (gender == null) return;
        switch (gender) {
            case MALE:
                getPage().click(genderMaleRadio);
                break;
            case FEMALE:
                getPage().click(genderFemaleRadio);
                break;
        }
    }
    public void enterFirstName(String firstName) {
        if (firstName == null) return;
        getPage().fill(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        if (lastName == null) return;
        getPage().fill(lastNameInput, lastName);
    }

    public void enterEmail(String email) {
        if (email == null)  return;
        getPage().fill(emailInput, email);
    }

    public void enterPassword(String password) {
        if (password == null) return;

        getPage().fill(passwordInput, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        if (confirmPassword == null) return;
        getPage().fill(confirmPasswordInput, confirmPassword);
    }

    public void clickRegister() {
        getPage().click(registerButton);
    }

    public String getSummaryError() {
        return getPage().innerText(summaryError);
    }

    public String getFieldValidationError() {
        return getPage().innerText(fieldValidationError);
    }

    @Override
    public boolean isOpened() {
        return getPage().url().endsWith("register");
    }
}