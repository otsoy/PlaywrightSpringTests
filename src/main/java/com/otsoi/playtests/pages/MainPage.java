package com.otsoi.playtests.pages;

import org.springframework.stereotype.Component;

import com.otsoi.playtests.blocks.SignInBlock;

import lombok.RequiredArgsConstructor;

@Component @RequiredArgsConstructor
public class MainPage implements WebPage {
    private final SignInBlock signInBlock;
    private final String registerLink = "//a[text()='Register']";

    public void open() {
        getPage().navigate("https://parabank.parasoft.com/parabank/index.htm", getCustomNavigateOptions());
    }

    public void clickRegister() {
        getPage().click(registerLink);
    }

    public SignInBlock getSignInBlock() {
        return signInBlock;
    }

    @Override
    public boolean isOpened() {
        return signInBlock.isVisible();
    }
}
