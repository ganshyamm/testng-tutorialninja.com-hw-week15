package com.tutorialninja.pages;

import com.tutorialninja.utility.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;


public class AccountRegisterPage extends UtilityClass {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;

    By subscribeRadios = By.xpath("//fieldset[3]//input");

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    public String getRegisterAccountText() {
        Reporter.log(" get text from register account" + registerAccountText);
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String fName) {

        Reporter.log(" enter first name" + firstNameField);

        sendTextToElement(firstNameField, fName);
    }

    public void enterLastName(String lName) {
        Reporter.log(" enter last name" + lastNameField);

        sendTextToElement(lastNameField, lName);
    }

    public void enterEmail(String email) {
        Reporter.log(" enter email in email field" + emailField);

        sendTextToElement(emailField, email);
    }

    public void enterTelephone(String telephone) {
        Reporter.log(" enter telephone number" + telephoneField);

        sendTextToElement(telephoneField, telephone);
    }

    public void enterPassword(String password) {
        Reporter.log(" enter password" + passwordField);

        sendTextToElement(passwordField, password);
    }

    public void enterConfirmPassword(String cPassword) {
        Reporter.log(" re enter password" + passwordConfirmField);

        sendTextToElement(passwordConfirmField, cPassword);
    }

    public void selectSubscription(String option) {
        Reporter.log(" select subscription from option" + subscribeRadios);

        List<WebElement> radioButtons = getListOfElements(subscribeRadios);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(option)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {
        Reporter.log(" click on privacy check box" + privacyPolicyCheckBox);

        clickOnElement(privacyPolicyCheckBox);
    }

    public void clickOnContinueButton() {
        Reporter.log(" continue button" + continueBtn);

        clickOnElement(continueBtn);
    }

}
