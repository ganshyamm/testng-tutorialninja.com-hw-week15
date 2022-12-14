package com.tutorialninja.pages;

import com.tutorialninja.utility.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class AccountLoginPage extends UtilityClass {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    public String getReturningCustomerText() {
        Reporter.log("return customer text" + returningCustomerText);

        return getTextFromElement(returningCustomerText);

    }

    public String getNewCustomerText() {
        Reporter.log("get text for new customer" + newCustomerText);
        return getTextFromElement(newCustomerText);
    }

    public void enterEmailAddress(String email) {
        Reporter.log("Enter email" + emailAddressField);

        sendTextToElement(emailAddressField, email);
    }

    public void enterPassword(String password) {
        Reporter.log(" enter password" + passwordField);

        sendTextToElement(passwordField, password);
    }


    public void clickOnLoginButton() {
        Reporter.log("click on login button" + loginBtn);

        clickOnElement(loginBtn);
    }

}
