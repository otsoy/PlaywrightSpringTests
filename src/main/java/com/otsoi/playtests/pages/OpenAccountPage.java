package com.otsoi.playtests.pages;

import java.util.List;

import org.springframework.stereotype.Component;

import com.otsoi.playtests.entities.AccountType;
import com.otsoi.playtests.utils.DropdownUtils;

@Component
public class OpenAccountPage implements WebPage {

    private final String accountTypeSelector = "//select[@id='type']";
    private final String sourceAccountSelector = "//select[@id='fromAccountId']";
    private final String openNewAccountButtonSelector = "//input[ @value='Open New Account']";
    private final String newAccountIdSelector = "//*[@id='newAccountId']";

    public void selectAccountType(AccountType accountType) {
        getPage().selectOption(accountTypeSelector, accountType.name());
    }

    public void selectSourceAccount() {
        DropdownUtils.selectFirstOption(getPage(), sourceAccountSelector);
    }

    public void clickOpenNewAccount() {
        getPage().click(openNewAccountButtonSelector);
    }

    public boolean isNewAccountOpened() {
        return getPage().waitForSelector(newAccountIdSelector).isVisible();
    }

    @Override
    public boolean isOpened() {
        return getPage().isVisible(accountTypeSelector);
    }

    public List<String> getAccountTypes() {
        return DropdownUtils.getAllOptions(getPage(), accountTypeSelector);
    }

    public List<String> getSourceAccounts() {
        return DropdownUtils.getAllOptions(getPage(), sourceAccountSelector);
    }

    public boolean isDisplayed() {
        return getPage().isVisible(accountTypeSelector);
    }
}