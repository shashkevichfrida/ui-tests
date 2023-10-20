package org.example.pages;

import org.example.driverManager.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancel;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    public CheckoutPage(){
        PageFactory.initElements(driver, this);
    }

    public CheckoutOverviewPage inputPersonalInformation(String firstNameValue, String lastNameValue, String postalCodeValue){
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        postalCode.sendKeys(postalCodeValue);

        continueButton.click();
        return new CheckoutOverviewPage();
    }
}
