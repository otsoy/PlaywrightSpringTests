package com.otsoi.playtests.pages;

import com.microsoft.playwright.Page;
import com.otsoi.playtests.blocks.HeaderBlock;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MainPage extends PlaywrightPageElement {

    private final RegisterPage registerPage;
    private final String registerButton = "//*[text()='Register']";

    public void open() {
        System.out.println(getPage().toString());
        getPage().navigate("http://demowebshop.tricentis.com/");
    }

    public RegisterPage clickRegister() {
        getPage().click(registerButton);
        return registerPage;
    }





}
