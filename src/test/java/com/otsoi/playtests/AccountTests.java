package com.otsoi.playtests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import com.otsoi.playtests.entities.AccountType;
import com.otsoi.playtests.extensions.AfterEachExtension;
import com.otsoi.playtests.extensions.TestBase;
import com.otsoi.playtests.steps.AccountSteps;
import com.otsoi.playtests.steps.MainPageSteps;
import com.otsoi.playtests.steps.SignInSteps;

@SpringBootTest @ExtendWith(AfterEachExtension.class)
public class AccountTests extends TestBase {

    @Autowired
    private MainPageSteps mainPageSteps;

    @Autowired
    private AccountSteps accountSteps;

    @Autowired
    private SignInSteps signInSteps;

    @Test @Description("Open a new account successfully")
    public void shouldOpenNewAccountSuccessfully() {
        mainPageSteps.open();
        signInSteps.signIn(currentUser);
        accountSteps.navigateToAccountOpening();
        accountSteps.openNewAccount();

        assertTrue(accountSteps.isAccountOpened(), "Account should be opened successfully");
    }

    @Test @Description("Open a checking account successfully")
    public void shouldOpenCheckingAccountSuccessfully() {

        mainPageSteps.open();
        signInSteps.signIn(currentUser);
        accountSteps.navigateToAccountOpening();
        accountSteps.openNewAccount(AccountType.CHECKING);

        assertTrue(accountSteps.isAccountOpened(), "Checking account should be opened successfully");
    }

    @Test @Description("Verify available account types")
    public void shouldVerifyAvailableAccountTypes() {
        mainPageSteps.open();
        signInSteps.signIn(currentUser);
        accountSteps.navigateToAccountOpening();

        List<String> accountTypes = accountSteps.getAvailableAccountTypes();
        assertTrue(accountTypes.contains("CHECKING"), "Checking account type should be available");
        assertTrue(accountTypes.contains("SAVINGS"), "Savings account type should be available");
    }

    @Test @Description("Verify source account selection")
    public void shouldVerifySourceAccountSelection() {
        mainPageSteps.open();
        signInSteps.signIn(currentUser);
        accountSteps.navigateToAccountOpening();

        List<String> sourceAccounts = accountSteps.getAvailableSourceAccounts();
        assertFalse(sourceAccounts.isEmpty(), "Source accounts list should not be empty");
    }

    @Test @Description("Verify account opening page navigation")
    public void shouldVerifyAccountOpeningPageNavigation() {
        mainPageSteps.open();
        signInSteps.signIn(currentUser);
        accountSteps.navigateToAccountOpening();

        assertTrue(accountSteps.isAccountOpeningPageDisplayed(), "Account opening page should be displayed");
    }
}