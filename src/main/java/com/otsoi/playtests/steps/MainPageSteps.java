package com.otsoi.playtests.steps;

import org.springframework.stereotype.Component;

import com.otsoi.playtests.pages.MainPage;

import lombok.RequiredArgsConstructor;

@Component @RequiredArgsConstructor
public class MainPageSteps {
    private final MainPage mainPage;

    public void open() {
        mainPage.open();
    }

    public void startRegistration() {
        mainPage.clickRegister();
        mainPage.waitForPageLoad();
    }

}
