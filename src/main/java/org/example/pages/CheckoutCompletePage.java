package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasketPage{
    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement buttonBackToProduct;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeHeader;

    public String getCompleteHeader(){
        return completeHeader.getText();
    }
}
