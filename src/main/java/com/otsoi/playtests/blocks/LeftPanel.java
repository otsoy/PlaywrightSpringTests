package com.otsoi.playtests.blocks;

import org.springframework.stereotype.Component;

import com.otsoi.playtests.pages.PlaywrightPageElement;

@Component
public class LeftPanel implements PlaywrightPageElement {

  private final String accountServicesLink = "//a[text()='Account Services']";
  private final String openNewAccountLink = "//a[text()='Open New Account']";
  private final String accountsOverviewLink = "//a[text()='Accounts Overview']";
  private final String transferFundsLink = "//a[text()='Transfer Funds']";
  private final String billPayLink = "//a[text()='Bill Pay']";
  private final String findTransactionsLink = "//a[text()='Find Transactions']";
  private final String updateContactInfoLink = "//a[text()='Update Contact Info']";
  private final String requestLoanLink = "//a[text()='Request Loan']";
  private final String logOutLink = "//a[text()='Log Out']";

  public void clickOpenNewAccount() {
    getPage().click(openNewAccountLink);
  }

  public void clickAccountServices() {
    getPage().click(accountServicesLink);
  }

  public void clickAccountsOverview() {
    getPage().click(accountsOverviewLink);
  }

  public void clickTransferFunds() {
    getPage().click(transferFundsLink);
  }

  public void clickBillPay() {
    getPage().click(billPayLink);
  }

  public void clickFindTransactions() {
    getPage().click(findTransactionsLink);
  }

  public void clickUpdateContactInfo() {
    getPage().click(updateContactInfoLink);
  }

  public void clickRequestLoan() {
    getPage().click(requestLoanLink);
  }

  public void clickLogOut() {
    getPage().click(logOutLink);
  }
}
