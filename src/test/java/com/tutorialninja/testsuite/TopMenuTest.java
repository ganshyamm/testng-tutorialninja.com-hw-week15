package com.tutorialninja.testsuite;

import com.tutorialninja.pages.*;
import com.tutorialninja.testbase.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TopMenuTest extends BaseTest {
    HomePage homePage;
    DesktopPage desktopPage;
    AccountRegisterPage accountRegisterPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ComponentsPage componentsPage;
    MyAccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        accountRegisterPage = new AccountRegisterPage();
        accountPage = new MyAccountPage();
        desktopPage =new DesktopPage();
        laptopsAndNotebooksPage =new LaptopsAndNotebooksPage();
        componentsPage =new ComponentsPage();

}
    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverOnDesktopsLinkAndClick();
        homePage.selectMenu("Show All Desktops");
        String expectedText = "Desktops";
        String actualText = desktopPage.getDesktopsText();
        Assert.assertEquals(actualText, expectedText, "Not navigate to Desktop page");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        Assert.assertEquals(laptopsAndNotebooksPage.getLaptopsAndNotebooksText(),
                "Laptops & Notebooks", "Not navigate to Laptops and Notebooks page");
    }

    @Test(groups = {"regression", "regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverOnComponentLinkAndClick();
        homePage.selectMenu("Show All Components");
        Assert.assertEquals(componentsPage.getComponentsText(),
                "Components", "Not navigate to Laptops and Notebooks page");
    }

}
