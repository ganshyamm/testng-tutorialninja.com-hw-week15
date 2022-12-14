package com.tutorialninja.testsuite;

import com.tutorialninja.pages.AccountLoginPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.MyAccountPage;
import com.tutorialninja.testbase.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AccountLoginPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    AccountLoginPage accountLoginPage = new AccountLoginPage();
    MyAccountPage accountPage = new MyAccountPage();

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyQAccountTab();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(accountLoginPage.getReturningCustomerText(),
                "Returning Customer", "Login page not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        homePage.clickOnMyQAccountTab();
        homePage.selectMyAccountOptions("Login");
        accountLoginPage.enterEmailAddress("prime123@gmail.com");
        accountLoginPage.enterPassword("test123");
        accountLoginPage.clickOnLoginButton();
        homePage.clickOnMyQAccountTab();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(accountPage.getAccountLogoutText(), "Account Logout", "Not logged out");
    }

}
