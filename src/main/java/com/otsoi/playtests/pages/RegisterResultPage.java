package com.otsoi.playtests.pages;

import com.microsoft.playwright.Page;
import com.otsoi.playtests.blocks.HeaderBlock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterResultPage <RegisterResultPage> extends PlaywrightPageElement implements WebPage, Logoutable{

    // Selectors
    private final String resultMessage = ".result";
    private final String continueButton = "//*[@value='Continue']";

    public void clickContinue() {
        getPage().click(continueButton);
    }
    @Override
    public boolean isOpened() {
        return getPage().isVisible(resultMessage);
    }

}