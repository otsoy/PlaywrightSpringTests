package com.otsoi.playtests.steps;

import org.springframework.stereotype.Component;

import com.otsoi.playtests.entities.TestUser;
import com.otsoi.playtests.pages.Logoutable;
import com.otsoi.playtests.pages.RegisterPage;
import com.otsoi.playtests.testData.TestUserFactory;

import lombok.RequiredArgsConstructor;

@Component @RequiredArgsConstructor
public class RegisterPageSteps implements Logoutable {
    private final RegisterPage registerPage;

    public RegisterPage register(TestUser user) {
        registerPage.enterFirstName(user.getFirstName());
        registerPage.enterLastName(user.getLastName());
        registerPage.enterAddress(user.getAddress());
        registerPage.enterCity(user.getCity());
        registerPage.enterState(user.getState());
        registerPage.enterZipCode(user.getZipCode());
        registerPage.enterPhone(user.getPhone());
        registerPage.enterSsn(user.getSsn());
        registerPage.enterUsername(user.getUsername());
        registerPage.enterPassword(user.getPassword());
        registerPage.enterConfirmPassword(user.getConfirmPassword());
        registerPage.clickRegister();

        return registerPage;
    }

    public RegisterPage registerRandom() {
        TestUser user = TestUserFactory.createRandom();
        return register(user);
    }
}
