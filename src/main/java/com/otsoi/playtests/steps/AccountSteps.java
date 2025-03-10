package com.otsoi.playtests.steps;

import java.util.List;

import org.springframework.stereotype.Component;

import com.otsoi.playtests.entities.AccountType;
import com.otsoi.playtests.pages.MainPage;
import com.otsoi.playtests.pages.OpenAccountPage;

import lombok.RequiredArgsConstructor;

@Component @RequiredArgsConstructor
public class AccountSteps {

    private final MainPage mainPage;
    private final OpenAccountPage openAccountPage;

    public void navigateToAccountOpening() {
        mainPage.getLeftPanel().clickOpenNewAccount();
    }

    public void openNewAccount(AccountType accountType) {
        openAccountPage.selectAccountType(accountType);
        openAccountPage.selectSourceAccount();
        openAccountPage.clickOpenNewAccount();
    }

    public void openNewAccount() {
        openNewAccount(AccountType.SAVINGS);
    }

    public boolean isAccountOpened() {
        return openAccountPage.isNewAccountOpened();
    }

    public List<String> getAvailableAccountTypes() {
        return openAccountPage.getAccountTypes();
    }

    public List<String> getAvailableSourceAccounts() {
        return openAccountPage.getSourceAccounts();
    }

    public boolean isAccountOpeningPageDisplayed() {
        return openAccountPage.isDisplayed();
    }
}