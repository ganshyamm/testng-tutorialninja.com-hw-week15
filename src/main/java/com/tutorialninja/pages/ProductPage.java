package com.tutorialninja.pages;

import com.tutorialninja.utility.UtilityClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;


public class ProductPage extends UtilityClass {
    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement productText;
    By calendarButton = By.xpath("//div[@class = 'input-group date']//button");
    By monthAndYearText = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    By nextButton = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    By dateList = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    By qtyField = By.cssSelector("#input-quantity");

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;
    By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
    By datePicker = By.xpath("//div[@class = 'input-group date']//button");


    public String getProductText() {
        Reporter.log("get text" + productText);

        return getTextFromElement(productText);
    }

    public void selectDeliveryDate(String day, String month, String year) {
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndYearText);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = getListOfElements(dateList);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(day)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAddToCartButton() {
        Reporter.log("click on add to cart button"  + addToCartButton);
        clickOnElement(addToCartButton);
    }

    public String getProductAddedSuccessMessage() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkIntoMessage() {
        clickOnElement(shoppingCartLink);
    }

    public void enterQuantity(String qty) {
        clearTextFromField(qtyField);
        sendTextToElement(qtyField, qty);
    }
}
