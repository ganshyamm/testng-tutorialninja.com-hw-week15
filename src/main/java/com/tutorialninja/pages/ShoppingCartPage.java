package com.tutorialninja.pages;

import com.tutorialninja.utility.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class ShoppingCartPage extends UtilityClass {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;
    By total = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");

    By qtyField = By.xpath("//input[contains(@name, 'quantity')]");

    By qtyUpdateBtn = By.xpath("//button[contains(@data-original-title, 'Update')]");

    By successModifiedMessage = By.xpath("//div[@id='checkout-cart']/div[1]");

    public String getShoppingCartText() {

        Reporter.log(" get text from shopping cart" + shoppingCartText);
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        Reporter.log(" get product name" + productName);
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        Reporter.log(" get dillivery date" + deliveryDate);
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        Reporter.log("get model" + model);

        return getTextFromElement(model);
    }

    public String getTotal() {

        Reporter.log("get total" + total);
        return getTextFromElement(total);
    }

    public void changeQuantity(String qty) {
        Reporter.log("qty change" + qtyField);
        sendTextToElement(qtyField, qty);
    }

    public void clickOnQtyUpdateButton() {
        Reporter.log("qty update " + qtyUpdateBtn);

        clickOnElement(qtyUpdateBtn);
    }

    public String getSuccessModifiedMessage() {
        Reporter.log("modified message" + successModifiedMessage);

        return getTextFromElement(successModifiedMessage);
    }
}
