package com.tutorialninja.pages;

import com.tutorialninja.utility.UtilityClass;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;


public class HomePage extends UtilityClass {

    By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsLinks;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab;
    By currencyList = By.xpath("//ul[@class = 'dropdown-menu']/li");
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    By myAccountOptions = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");


    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(topMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(topMenu);
        }
    }

    public void mouseHoverOnDesktopsLinkAndClick() {

        Reporter.log("click on desktop link" + desktopLink);
        mouseHoverToElementAndClick(desktopLink);
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        Reporter.log("click on laptop and notebook link" + laptopsAndNotebooksLink);
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
    }

    public void mouseHoverOnComponentLinkAndClick() {
        Reporter.log("click on components link" + componentsLinks);
        mouseHoverToElementAndClick(componentsLinks);
    }

    public void selectCurrency(String currency) {
        clickOnElement(currencyTab);
        List<WebElement> listOfElements = getListOfElements(currencyList);
        for (WebElement e : listOfElements) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnMyQAccountTab() {
        Reporter.log("click on account tab" + myAccountTab);
        clickOnElement(myAccountTab);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = getListOfElements(myAccountOptions);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(myAccountOptions);
        }
    }
}
