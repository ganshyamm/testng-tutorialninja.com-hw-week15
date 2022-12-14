package com.tutorialninja.pages;

import com.tutorialninja.utility.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * Created by Jay Vaghani
 */
public class MyAccountPage extends UtilityClass {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;
    @CacheLookup
    @FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
   WebElement accountCreatedText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;


    public String getAccountLogoutText() {
        Reporter.log("get text from account logout" + accountLogoutText);
        return getTextFromElement(accountLogoutText);
    }

    public String getYourAccountHasBeenCreatedText() {
        Reporter.log("get text account has been created" + accountCreatedText);

        return getTextFromElement(accountCreatedText);
    }

    public void clickOnContinueButton() {
        Reporter.log(" click on continue button" + continueBtn);

        clickOnElement(continueBtn);
    }
}
