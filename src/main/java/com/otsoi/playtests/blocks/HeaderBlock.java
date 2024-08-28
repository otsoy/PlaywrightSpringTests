package com.otsoi.playtests.blocks;

import com.otsoi.playtests.pages.PlaywrightPageElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeaderBlock extends PlaywrightPageElement {
    private final String logoutButton = "//*[text()='Log out']";

    public void clickLogout() {
      getPage().click(logoutButton);
    }

}
