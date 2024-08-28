package com.otsoi.playtests.steps;

import com.otsoi.playtests.entities.TestUser;
import com.otsoi.playtests.pages.MainPage;
import com.otsoi.playtests.pages.RegisterPage;
import com.otsoi.playtests.pages.RegisterResultPage;
import com.otsoi.playtests.pages.SpringContext;
import com.otsoi.playtests.testData.TestUserFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainPageSteps {
    private final MainPage mainPage;

    public void open() {
        mainPage.open();
    }

    public void startRegistration() {
        mainPage.clickRegister();
    }
}
