package com.otsoi.playtests.pages;

import org.springframework.stereotype.Component;

import com.otsoi.playtests.blocks.LeftPanel;
import com.otsoi.playtests.blocks.SignInBlock;

import lombok.RequiredArgsConstructor;

@Component @RequiredArgsConstructor
public class MainPage implements WebPage {
    private final SignInBlock signInBlock;
    private final LeftPanel leftPanel;

    public void open() {
        getPage().navigate("https://parabank.parasoft.com/parabank/index.htm", getCustomNavigateOptions());
    }

    public SignInBlock getSignInBlock() {
        return signInBlock;
    }

    public LeftPanel getLeftPanel() {
        return leftPanel;
    }

    @Override
    public boolean isOpened() {
        return signInBlock.isVisible();
    }
}
