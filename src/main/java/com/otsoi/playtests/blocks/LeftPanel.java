package com.otsoi.playtests.blocks;

import org.springframework.stereotype.Component;

import com.otsoi.playtests.pages.PlaywrightPageElement;

import lombok.RequiredArgsConstructor;

@Component @RequiredArgsConstructor
public class LeftPanel implements PlaywrightPageElement {
  private final String logoutButton = "//*[text()='Log Out']";

  public void clickLogout() {
    getPage().click(logoutButton);
  }

}
