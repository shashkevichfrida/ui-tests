package org.example.pages;

import org.example.driverManager.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasketPage extends BasePage {
    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShopping;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkout;

    @FindBy(xpath = "//div[@class='cart_item']")
    private List<WebElement> cartItems;

    public BasketPage(){
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage checkout(){
        checkout.click();
        return new CheckoutPage();
    }

    public Integer getSizeOfCartItems(){
        return cartItems.size();
    }

    public InventoryPage continueShopping(){
        continueShopping.click();

        return new InventoryPage();
    }
}
